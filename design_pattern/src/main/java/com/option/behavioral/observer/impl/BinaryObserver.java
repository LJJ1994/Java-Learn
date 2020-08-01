package com.option.behavioral.observer.impl;

import com.option.behavioral.observer.Observer;
import com.option.behavioral.observer.Subject;

public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }
}