package main.java.core.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-05 12:56:56
 * @Modified By:
 */
public class SimpleDiamon implements Runnable {
    @Override
    public void run() {
       try{
           while (true){
               TimeUnit.MILLISECONDS.sleep(2000);
               System.out.println(Thread.currentThread() + ": " + this);
           }
       } catch(InterruptedException e){
           e.printStackTrace();
           System.out.println("Thread interrupted");
       }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new SimpleDiamon());
            thread.setDaemon(true);// 后台线程
            thread.start();
        }
        System.out.println("All daemons started....");
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
