package com.option.creational.prototype.impl;

import com.option.creational.prototype.Shape;

public class Square extends Shape {
    public Square(){
        type = "Square";
    }
    public void draw() {
        System.out.println("Square draw....");
    }
}
