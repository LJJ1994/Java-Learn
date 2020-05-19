package main.java.core.concurrency;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-06 09:06:06
 * @Modified By:
 */
class SyncA{
    private Object syncObject = new Object();

    public synchronized void f(){
        for(int i=0; i<5; i++){
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g(){
        synchronized (syncObject){
            for(int i=0; i<5; i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
public class SyncObject {
    public static void main(String[] args) {
        final SyncA syncA = new SyncA();
        new Thread(){
            @Override
            public void run() {
                syncA.f();
            }
        }.start();
        syncA.g();
    }
}
