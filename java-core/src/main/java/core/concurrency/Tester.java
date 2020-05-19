package main.java.core.concurrency;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-08 09:30:30
 * @Modified By:
 */
public abstract class Tester<C> {
    static int testRepos = 10;
    static int testCycles = 1000;
    static int containSize = 1000;
    abstract C containerInitializer();
    abstract void startReadersAndWriter();
    C testContainer;
    String testId;
    int nReaders;
    int nWriters;
    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;
    CountDownLatch endLatch;
    static ExecutorService executorService = Executors.newCachedThreadPool();
    Integer[] writeData;

    Tester(String testId, int nReaders, int nWriters){
        this.testId = testId + " " + nReaders + "r " + nWriters + "w";
        this.nReaders = nReaders;
        this.nWriters = nWriters;

        writeData = Generated.array(Integer.class, new RandomGenerator.Integer(), containSize);
        for (int i = 0; i < testRepos; i++) {
            runTest();
            readTime = 0;
            writeTime = 0;
        }
    }

    private void runTest(){
        endLatch = new CountDownLatch(nReaders + nWriters);
        testContainer = containerInitializer();
        startReadersAndWriter();
        try{
            endLatch.await();
        } catch (InterruptedException e){
            System.out.println("endLatch Interrupted!");
        }
        System.out.printf("%-27s %14d %14d\n", testId, readTime, writeTime);
        if(writeTime != 0 && readTime != 0){
            System.out.printf("%-27s %14d\n", "readTime + writeTime = ", readTime + writeTime);
        }
    }

    abstract class TestTask implements Runnable{
        abstract void test();
        abstract void putResults();
        long duration;
        public void run(){
            long startTime = System.nanoTime();
            test();
            duration = System.nanoTime() - startTime;
            synchronized(Tester.this){
                putResults();
            }
            endLatch.countDown();
        }
    }

    public static void intMain(String[] args) {
        System.out.printf("%-27s %14s %14s\n", "Type", "Read Time", "Write Time");
    }
}
