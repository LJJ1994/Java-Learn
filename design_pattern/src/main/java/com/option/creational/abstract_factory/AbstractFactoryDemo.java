package com.option.creational.abstract_factory;

import com.option.creational.abstract_factory.color.Color;
import com.option.creational.abstract_factory.shape.Shape;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getAbstractFactory("Shape");
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        AbstractFactory colorFactory = FactoryProducer.getAbstractFactory("Color");
        Color blue = colorFactory.getColor("blue");
        blue.fill();
    }
}
