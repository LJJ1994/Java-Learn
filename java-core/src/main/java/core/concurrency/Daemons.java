package main.java.core.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-05 13:23:23
 * @Modified By:
 */
public class Daemons  {
    public static void main(String[] args) {
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        boolean isDaemon = thread.isDaemon();
        System.out.println("thread is Daemon = " + isDaemon);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Daemon implements Runnable{
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for (int i=0; i<t.length; i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + "start");
        }
        for(int i=0; i<t.length; i++){
            boolean isDaemon = t[i].isDaemon();
            System.out.println("t[" + i + "]" + "isDaemon = " + isDaemon);
        }
        while (true){
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable{

    @Override
    public void run() {
        while(true){
            Thread.yield();
        }
    }
}
