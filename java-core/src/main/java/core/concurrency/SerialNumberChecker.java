package main.java.core.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-06 07:20:20
 * @Modified By:
 */
class CircularSet{
    private int[] arr;
    private int len;
    private int index = 0;

    public CircularSet(int size){
        arr = new int[size];
        len = size;
        for(int i=0; i<len; i++){
            arr[i] = -1;
        }
    }

    public synchronized void add(int num){
        arr[index] = num;
        index = ++index%len;
    }

    public synchronized boolean contains(int val){
        for(int i=0; i<len; i++){
            if(arr[i] == val){
                return true;
            }
        }
        return false;
    }
}

public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable{

        @Override
        public void run() {
            while (true){
                int serialNumber = SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serialNumber)){
                    System.out.println("Duplicated: " + serialNumber);
                    System.exit(0);
                }
                serials.add(serialNumber);
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<SIZE; i++){
            executorService.execute(new SerialChecker());
        }
        if(args.length > 0){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("No Duplicated detected!");
            System.exit(0);
        }
    }
}
