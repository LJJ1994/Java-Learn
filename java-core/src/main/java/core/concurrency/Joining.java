package main.java.core.concurrency;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-05 13:55:55
 * @Modified By:
 */
class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name, int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    public void run(){
        try {
            sleep(1000);
        } catch (InterruptedException e){
            System.out.println(getName() + " was interrupted, " + "isInterrupted() " + isInterrupted());
            return;
        }
        System.out.println(getName() + " awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run(){
        try{
            sleeper.join();
        } catch(InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println(getName() + " join completed!");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper1 = new Sleeper("sleeper1", 1500);
        Sleeper sleeper2 = new Sleeper("sleeper2", 1500);
        Joiner joiner1 = new Joiner("joiner1", sleeper1);
        Joiner joiner2 = new Joiner("joiner2", sleeper2);
//        sleeper2.interrupt();
    }
}
