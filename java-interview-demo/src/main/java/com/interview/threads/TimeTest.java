package com.interview.threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TimeTest {
    public static long test(int nThreads, final Runnable task) throws InterruptedException {
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try{
                    startLatch.await();
                    try{
                        task.run();
                    } finally {
                        endLatch.countDown();
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
            t.start();
        }
        long start = System.nanoTime();
        startLatch.countDown();
        endLatch.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static class TestTask implements Runnable{

        @Override
        public void run() {
            Random random = new Random(47);
            System.out.println("i: " + random.nextInt(10));
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        int nThreads = 10000;
//        long test = test(nThreads, new TestTask());
//        System.out.println("cost Time: " + test);
//        System.out.println(Runtime.getRuntime().availableProcessors());

        boolean flag = false;
        if (flag = true){
            System.out.println("true");
        } else{
            System.out.println("false");
        }
    }

    private void waitForSignal() throws InterruptedException {
        Object obj = new Object();
        synchronized (Thread.currentThread()){
            obj.wait();
            obj.notify();
        }
    }
}
