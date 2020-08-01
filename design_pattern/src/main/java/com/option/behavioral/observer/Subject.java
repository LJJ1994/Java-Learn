package com.option.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObservers();
    }

    /**
     * 订阅被观察者
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 被观察者发生状态变化，通知所有订阅者
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
