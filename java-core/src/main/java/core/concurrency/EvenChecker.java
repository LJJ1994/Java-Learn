package main.java.core.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-06 03:28:28
 * @Modified By:
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    EvenChecker(IntGenerator g, int ident){
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if(val%2 != 0){
                System.out.println(val + " is Not a Even Number!");
                generator.canceled();
            }
        }
    }

    public static void test(IntGenerator ig, int count){
        System.out.println("Press Control + C to exit.");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<count; i++){
            executorService.execute(new EvenChecker(ig, i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator intGenerator){
        test(intGenerator, 10);
    }
}
