package com.interview.threads;

import java.util.concurrent.*;

public class FutureTest {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        Future<Integer> submit = executorService.submit(task);
        System.out.println("get result: " + submit.get());
        System.exit(1);
    }
}

class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        Integer sum=0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        return sum;
    }
}
