package com.option.creational.prototype.impl;

import com.option.creational.prototype.Shape;

public class Circle extends Shape {
    public Circle(){
        type = "Circle";
    }
    public void draw() {
        System.out.println("Circle draw...");
    }
}
