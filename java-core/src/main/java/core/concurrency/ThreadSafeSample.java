package main.java.core.concurrency;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-28 16:07:07
 * @Modified By:
 */
public class ThreadSafeSample {
    private int shareState;
    public void nonSafeAction(){
        while (shareState < 100000){
            synchronized (this){
                int former = shareState++;
                int later = shareState;
                if (former != (later - 1)){
                    System.out.println("Observed race data " + "former: " + former + ", later: " + later);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSample sample = new ThreadSafeSample();
        Thread threadA = new Thread(){
            public void run(){
                sample.nonSafeAction();
            }
        };
        Thread threadB = new Thread(){
            public void run(){
                sample.nonSafeAction();
            }
        };
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
