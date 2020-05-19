package main.java.core.innerclasses.controller;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 21:27:27
 * @Modified By:
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime){
        this.delayTime = delayTime;
        start();
    }

    public void start(){
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    public abstract void action(); // 留给继承类去实现
}
