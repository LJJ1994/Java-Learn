package com.option.creational.abstract_factory;

import com.option.creational.abstract_factory.color.Color;
import com.option.creational.abstract_factory.shape.Shape;


public abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
    abstract Color getColor(String colorType);
}
