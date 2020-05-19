package main.java.core.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-05 12:37:37
 * @Modified By:
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private int priority;
    private volatile double d;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for(int i=1; i<100000; i++){
                d += (Math.PI +Math.E) / (double) i;
                if (i % 1000 == 0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            executorService.submit(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.submit(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
