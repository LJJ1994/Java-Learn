package com.interview.threads;

class InterruptedStop1 extends Thread{
    private String name;
    public InterruptedStop1(String name){
        this.name = name;
    }
    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("线程 " + name + " 正在运行...");
            } catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
        System.out.println("线程退出...");
    }
}

public class InterruptedStopTest1 {
    public static void main(String[] args) {
        InterruptedStop1 stop1 = new InterruptedStop1("A");
        stop1.start();
        try {
            Thread.sleep(3000);
            System.out.println("线程终止...");
            stop1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
