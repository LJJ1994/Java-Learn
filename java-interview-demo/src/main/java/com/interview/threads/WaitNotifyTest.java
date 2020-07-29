package com.interview.threads;

import java.util.*;

public class WaitNotifyTest {
    public static void main(String[] args) {
        TaskQueue queue = new TaskQueue();
        List<Thread> list = new ArrayList<>();
        // 多线程获取队列任务
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(()->{
                while (true){
                    String s = queue.getTask();
                    System.out.println("execute task: " + s);
                }
            });
            t.start();
            list.add(t);
        }
        // 开启一个线程添加10个任务
        Thread add = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                queue.addTask(s);
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        add.start();
        try{
            add.join();
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        for (Thread thread : list) {
            thread.interrupt();
        }
    }
}

class TaskQueue {
    private Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s){
        queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask(){
        while (queue.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }
}
