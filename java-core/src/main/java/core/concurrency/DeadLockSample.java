package main.java.core.concurrency;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-29 08:18:18
 * @Modified By:
 */
public class DeadLockSample extends Thread {
    private String first;
    private String second;
    public DeadLockSample(String name, String first, String second){
        super(name);
        this.first = first;
        this.second = second;
    }

    public void run(){
        synchronized (first){
            System.out.println(this.getName() + " obtained " + first);
            try{
                Thread.sleep(1000L);
                synchronized (second){
                    System.out.println(this.getName() + " obtained " + second);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        Runnable dlCheck = new Runnable() {
            @Override
            public void run() {
                long[] threadIds = threadMXBean.findDeadlockedThreads();
                if(threadIds != null){
                    ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(threadIds);
                    System.out.println("detect dead lock...");
                    for (ThreadInfo info : threadInfo) {
                        System.out.println(info.getThreadName());
                    }
                }
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);

        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSample A = new DeadLockSample("LockA", lockA, lockB);
        DeadLockSample B = new DeadLockSample("LockB", lockB, lockA);
        A.start();
        B.start();
        A.join();
        B.join();
    }
}
