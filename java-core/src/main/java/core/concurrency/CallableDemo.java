package main.java.core.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-05 10:32:32
 * @Modified By:
 */
class TaskWithResult implements Callable<String>{
    private int id;

    TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "task #" + id + " result";
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futures = new ArrayList<>();
        for(int i=0; i<1000; i++){
            Future<String> submit = executorService.submit(new TaskWithResult(i));
            futures.add(submit);
        }

        for (Future<String> future : futures){
            try{
                System.out.println(future.get());
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
