package com.option.structural.bridge.shape;

import com.option.structural.bridge.DrawAPI;

public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
