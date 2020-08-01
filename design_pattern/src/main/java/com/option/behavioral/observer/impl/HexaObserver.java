package com.option.behavioral.observer.impl;

import com.option.behavioral.observer.Observer;
import com.option.behavioral.observer.Subject;

public class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase());
    }
}
