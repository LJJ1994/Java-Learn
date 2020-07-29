package com.interview.threads;

public class KeywordStopTest {
    public static void main(String[] args) throws InterruptedException{
        KeywordStop keywordStop = new KeywordStop("A");
        new Thread(keywordStop).start();
        Thread.sleep(3000);
        keywordStop.isExit = true;
    }
}

class KeywordStop implements Runnable{
    private String name;
    public KeywordStop(String name){
        this.name = name;
    }
    public volatile boolean isExit = false;

    @Override
    public void run() {
        while (!isExit){
            try{
                System.out.println("线程 " + name + " 正在运行...");
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("线程运行结束...");
    }
}

