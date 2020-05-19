package main.java.core.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-29 09:57:57
 * @Modified By:
 */
public class UsualSemaphoreSample {
}

class SemaphoreWorker implements Runnable{
    private String name;
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try{
            log("is waiting for a permit!");
            semaphore.acquire();
            log("acquired a permit!");
            log("executed!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            log("released a permit!");
            semaphore.release();
        }
    }

    private void log(String msg){
        if (name == null){
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " + msg);
    }

    public static void main(String[] args) {
        System.out.println("action go!");
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SemaphoreWorker(semaphore));
            thread.start();
        }
    }
}
