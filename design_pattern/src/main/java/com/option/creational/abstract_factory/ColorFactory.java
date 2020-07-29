package com.option.creational.abstract_factory;

import com.option.creational.abstract_factory.color.Color;
import com.option.creational.abstract_factory.color.impl.Blue;
import com.option.creational.abstract_factory.color.impl.Green;
import com.option.creational.abstract_factory.color.impl.Red;
import com.option.creational.abstract_factory.shape.Shape;

public class ColorFactory extends AbstractFactory{
    @Override
    Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        if (null == colorType) {
            return null;
        }
        if (colorType.equalsIgnoreCase("Red")) {
            return new Red();
        }else if (colorType.equalsIgnoreCase("Blue")) {
            return new Blue();
        }else if (colorType.equalsIgnoreCase("Green")) {
            return new Green();
        }else {
            return null;
        }
    }
}
