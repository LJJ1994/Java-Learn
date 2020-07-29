package com.option.structural.facade.impl;

import com.option.structural.facade.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square draw...");
    }
}
