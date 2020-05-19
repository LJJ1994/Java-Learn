package main.java.core.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-29 13:43:43
 * @Modified By:
 */
public class CyclicBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("action Go!");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CyclicWorker(cyclicBarrier));
            thread.start();
        }
    }
}

class CyclicWorker implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public CyclicWorker(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 3; i++) {
                System.out.println("Executed!");
                cyclicBarrier.await();
            }
        } catch (BrokenBarrierException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
