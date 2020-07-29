package com.option.structural.proxy.jdk_proxy.impl;

import com.option.structural.proxy.jdk_proxy.Subject;

public class RealSubject implements Subject {
    @Override
    public int sellBooks() {
        System.out.println("I sell 10 books");
        return 10;
    }

    @Override
    public String speak() {
        System.out.println("zhang say: Hello World!");
        return "Yes!";
    }
}
