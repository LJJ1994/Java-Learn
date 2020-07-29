package com.interview.threads;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

class Task1 implements Runnable{

    @Override
    public void run() {
        System.out.println("thread1 start....");
    }
}

class Task2 extends Thread{
    @Override
    public void run(){
        System.out.println("trhead2 start....");
    }
}

class Task3 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("start future task");
        int a = 1 << 5;
        return a;
    }
}

public class DemoThread1 {
    private static ThreadLocal<Person> personThreadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Task1 task1 = new Task1();
//        Thread thread = new Thread(task1);
//        thread.start();
//        Task2 task2 = new Task2();
//        task2.start();
        Task3 task3 = new Task3();
        FutureTask<Task3> futureTask = new FutureTask<Task3>(task3);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());

        AtomicInteger integer = new AtomicInteger();
        Integer.toString(12);


    }

    private static class Person{
        private int age;
        private String name;
        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
