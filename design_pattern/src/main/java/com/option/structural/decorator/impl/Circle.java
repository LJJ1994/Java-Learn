package com.option.structural.decorator.impl;

import com.option.structural.decorator.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw....");
    }

    public String toString(){
        return "Circle ";
    }
}
