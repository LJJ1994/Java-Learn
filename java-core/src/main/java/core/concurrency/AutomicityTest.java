package main.java.core.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-06 07:03:03
 * @Modified By:
 */
public class AutomicityTest implements Runnable {
    private int i = 0;
    public synchronized int getValue(){
        return i;
    }

    public synchronized void increment(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true){
            increment();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AutomicityTest automicityTest = new AutomicityTest();
        executorService.execute(automicityTest);
        while (true){
            int val = automicityTest.getValue()%2;
            if( val != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
