package com.interview.threads;

import java.util.concurrent.*;

public class FutureTaskTest {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executorService.submit(futureTask);
        try {
            System.out.println("get result: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
