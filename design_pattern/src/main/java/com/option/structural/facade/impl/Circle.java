package com.option.structural.facade.impl;

import com.option.structural.facade.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw...");
    }
}
