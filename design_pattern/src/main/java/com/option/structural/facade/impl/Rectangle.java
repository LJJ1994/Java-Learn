package com.option.structural.facade.impl;

import com.option.structural.facade.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle draw....");
    }
}
