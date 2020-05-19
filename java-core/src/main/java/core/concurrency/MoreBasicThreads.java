package main.java.core.concurrency;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-05 10:07:07
 * @Modified By:
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
        System.out.println("Waiting for LiftOff!");
    }
}
