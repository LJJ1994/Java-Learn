package main.java.core.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-29 13:29:29
 * @Modified By:
 */
public class LatchSample {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new FirstBatchWorker(countDownLatch));
            thread.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SecondBatchWorker(countDownLatch));
            thread.start();
        }
        while (countDownLatch.getCount()!=1){
            Thread.sleep(100L);
        }
        System.out.println("wait for first batch finished!");
        countDownLatch.countDown();
    }
}

class FirstBatchWorker implements Runnable{
    private CountDownLatch countDownLatch;
    public FirstBatchWorker(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
            System.out.println("first countdown executed!");
            countDownLatch.countDown();
    }
}

class SecondBatchWorker implements Runnable{
    private CountDownLatch countDownLatch;
    public SecondBatchWorker(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try{
            countDownLatch.await();
            System.out.println("second countdown executed!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

