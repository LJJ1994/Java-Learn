package com.option.creational.abstract_factory.shape.impl;

import com.option.creational.abstract_factory.shape.Shape;

public class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle has been invoked!");
    }
}
