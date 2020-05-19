package main.java.core.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-06 10:27:27
 * @Modified By:
 */
class Count{
    private int count = 0;
    private Random rand = new Random(47);

    public synchronized int increment(){
        int temp = count;
        if(rand.nextBoolean()){ // 增加失败的概率
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value(){
        return count;
    }
}

class Entrance implements Runnable{
    private static Count count = new Count();
    private int number = 0;
    private final int id;
    private static List<Entrance> entrances = new ArrayList<>();
    private static volatile boolean canceled = false;

    public static void cancel(){
        canceled = true;
    }

    public Entrance(int idx){
        id = idx;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled){
            synchronized (this){
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e){
                System.out.println("Interrupted!");
            }
        }
    }

    public synchronized int getValue(){
        return number;
    }

    public String toString(){
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int sumEntrances(){
        int sum = 0;
        for(Entrance entrance : entrances){
            sum += entrance.getValue();
        }
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Entrance(i));
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Entrance.cancel();
        executorService.shutdown();
        if(!executorService.awaitTermination(200, TimeUnit.MILLISECONDS)){
            System.out.println("some task are not terminated!");
        }
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
