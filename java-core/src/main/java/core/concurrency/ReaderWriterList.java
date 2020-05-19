package main.java.core.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-08 12:14:14
 * @Modified By:
 */
public class ReaderWriterList<T> {
    private ArrayList<T> lockedList;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReaderWriterList(int size, T initialSize){
        lockedList = new ArrayList<T>(Collections.nCopies(size, initialSize));
    }

    public T set(int index, T element){
        Lock wlock = lock.writeLock();
        wlock.lock();
        try{
            return lockedList.set(index, element);
        } finally {
            wlock.unlock();
        }
    }

    public T get(int index){
        Lock rlock = lock.readLock();
        rlock.lock();
        try{
            if(lock.getReadLockCount() > 1){
                System.out.println(lock.getReadLockCount());
            }
            return lockedList.get(index);
        } finally {
            rlock.unlock();
        }
    }

    public static void main(String[] args) {
        new ReaderWriterListTest(30, 1);
    }
}

class ReaderWriterListTest {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private static final int SIZE = 100;
    private static Random random = new Random(47);
    private ReaderWriterList<Integer> list = new ReaderWriterList<>(SIZE, 0);

    private class Writer implements Runnable{

        @Override
        public void run() {
            try{
                for (int i = 0; i < 20; i++) {
                    list.set(i, random.nextInt());
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Writer finished, shutting down.");
            executorService.shutdownNow();
        }
    }

    private class Reader implements Runnable{

        @Override
        public void run() {
            try{
                while (!Thread.interrupted()){
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public ReaderWriterListTest(int readers, int writers){
        for (int i = 0; i < readers; i++) {
            executorService.execute(new Reader());
        }

        for (int i = 0; i < writers; i++) {
            executorService.execute(new Writer());
        }
    }
}
