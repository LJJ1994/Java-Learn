package main.java.core.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-06 07:41:41
 * @Modified By:
 */
public class AutomicNumberTest implements Runnable{
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue(){
        return i.get();
    }

    public void setValue(){
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true){
            setValue();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Abort..");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AutomicNumberTest numberTest = new AutomicNumberTest();
        executorService.execute(numberTest);
        while (true) {
            int value = numberTest.getValue();
            if(value%2 != 0){
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}
