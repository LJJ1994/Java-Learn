package main.java.core.concurrency;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-07 15:59:59
 * @Modified By:
 */
abstract class Accumulator{
    public static long cycles = 50000L;
    private static final int N = 4;
    public static ExecutorService executorService = Executors.newFixedThreadPool(N*2);
    private static CyclicBarrier barrier = new CyclicBarrier(N*2 + 1);

    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected final static int SIZE = 500000;
    protected static int[] preloaded = new int[SIZE];

    static {
        Random random = new Random(47);
        for (int i = 0; i < SIZE; i++) {
            preloaded[i] = random.nextInt();
        }
    }

    public abstract void accumulate();
    public abstract long read();

    private class Modifier implements Runnable{

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                accumulate();
            }
            try{
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e){
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable{
        private volatile long value;
        @Override
        public void run() {
            for (long i=0; i<cycles; i++){
                value = read();
            }
            try{
                barrier.await();
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public void timeTest(){
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            executorService.execute(new Modifier());
            executorService.execute(new Reader());
        }
        try{
            barrier.await();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-13s: %13d\n", id, duration);
    }

    public static void report(Accumulator acc1, Accumulator acc2){
        System.out.printf("%-22s: %.2f\n", acc1.id + "/" + acc2.id,
                (double)acc1.duration/(double)acc2.duration);
    }
}

class BaseLine extends Accumulator{
    {
        id="BaseLine";
    }

    @Override
    public void accumulate() {
        value += preloaded[index++];
        if(index >= SIZE){
            index = 0;
        }
    }

    @Override
    public long read() {
        return value;
    }
}

class SynchronizedTest extends Accumulator{
    {
        id="synchronized";
    }

    @Override
    public synchronized void accumulate() {
        value += preloaded[index++];
        if(index >= SIZE){
            index = 0;
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}

class LockTest extends Accumulator{
    {
        id="lock";
    }
    private Lock lock = new ReentrantLock();
    @Override
    public void accumulate() {
        lock.lock();
        try{
            value += preloaded[index++];
            if(index >= SIZE) {
                index = 0;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long read() {
        lock.lock();
        try{
            return value;
        } finally {
            lock.unlock();
        }
    }
}

class AtomicTest extends Accumulator{
    {
        id = "atomic";
    }
    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);

    @Override
    public void accumulate() {
        int i = index.getAndIncrement();
        value.getAndAdd(preloaded[i]);
        if(++i >= SIZE){
            index.set(0);
        }
    }

    @Override
    public long read() {
        return value.get();
    }
}

public class SynchronizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synchronizedTest = new SynchronizedTest();
    static LockTest lockTest = new LockTest();
    static AtomicTest atomicTest = new AtomicTest();
    static void test(){
        System.out.println("=========================");
        System.out.printf("%-12s : %13d\n", "Cycles", Accumulator.cycles);
        baseLine.timeTest();
        synchronizedTest.timeTest();
        lockTest.timeTest();
        atomicTest.timeTest();
        Accumulator.report(synchronizedTest, baseLine);
        Accumulator.report(lockTest, baseLine);
        Accumulator.report(atomicTest, baseLine);

        Accumulator.report(synchronizedTest, lockTest);
        Accumulator.report(synchronizedTest, atomicTest);
        Accumulator.report(lockTest, atomicTest);
    }

    public static void main(String[] args) {
        int iterations = 5; //默认
        System.out.println("Warm up!");
        baseLine.timeTest();
        System.out.println();
        for (int i = 0; i < iterations; i++) {
            test();
            Accumulator.cycles *= 2;
        }
        Accumulator.executorService.shutdown();
    }
}
