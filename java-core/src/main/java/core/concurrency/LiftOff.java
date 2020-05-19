package main.java.core.concurrency;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-05 09:57:57
 * @Modified By:
 */
public class LiftOff implements Runnable{
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    LiftOff(){}

    LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status() {
        String str = countDown > 0 ? String.valueOf(countDown) : "LiftOff!";
        return "#" + String.valueOf(id) + "(" + str + ")";
    }

    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
