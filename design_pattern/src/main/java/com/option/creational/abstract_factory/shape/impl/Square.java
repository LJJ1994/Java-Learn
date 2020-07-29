package com.option.creational.abstract_factory.shape.impl;


import com.option.creational.abstract_factory.shape.Shape;

public class Square implements Shape {
    public void draw() {
        System.out.println("Square has been invoked!");
    }
}
