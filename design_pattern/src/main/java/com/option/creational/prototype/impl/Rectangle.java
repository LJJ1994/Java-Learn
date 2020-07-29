package com.option.creational.prototype.impl;

import com.option.creational.prototype.Shape;

public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    public void draw() {
        System.out.println("Rectangle draw....");
    }
}
