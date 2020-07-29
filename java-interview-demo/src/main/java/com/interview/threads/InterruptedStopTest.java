package com.interview.threads;

public class InterruptedStopTest {
    public static void main(String[] args) throws InterruptedException{
        InterruptedStop interruptedStop = new InterruptedStop("A");
        interruptedStop.start();
        Thread.sleep(100);
        System.out.println("中断线程");
        interruptedStop.interrupt();
    }
}

class InterruptedStop extends Thread{
    private String name;
    public InterruptedStop(String name){
        this.name = name;
    }
    @Override
    public void run(){
        while (!isInterrupted()){
            System.out.println("线程 " + name + " 正在运行....");
        }
        System.out.println("线程运行结束...");
    }
}

