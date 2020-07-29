package com.option.structural.bridge.shape.impl;

import com.option.structural.bridge.DrawAPI;
import com.option.structural.bridge.shape.Shape;

public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;
    public Circle(int x, int y, int radius, DrawAPI drawAPI){
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
