package com.option.behavioral.observer;

import com.option.behavioral.observer.impl.BinaryObserver;
import com.option.behavioral.observer.impl.HexaObserver;
import com.option.behavioral.observer.impl.OctalObserver;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        BinaryObserver binaryObserver = new BinaryObserver(subject);
        HexaObserver hexaObserver = new HexaObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);

        System.out.println("===============First change=======================");
        subject.setState(5);
        System.out.println("================Second change======================");
        subject.setState(10);
    }
}
