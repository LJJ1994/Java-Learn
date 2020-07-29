package com.option.structural.decorator.impl;

import com.option.structural.decorator.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square draw....");
    }

    public String toString(){
        return "Square ";
    }
}
