package com.option.creational.abstract_factory;

import com.option.creational.abstract_factory.color.Color;
import com.option.creational.abstract_factory.shape.Shape;
import com.option.creational.abstract_factory.shape.impl.Circle;
import com.option.creational.abstract_factory.shape.impl.Rectangle;
import com.option.creational.abstract_factory.shape.impl.Square;

public class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType){
        if (null == shapeType) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }else if (shapeType.equalsIgnoreCase("Circle")){
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        } else {
            return null;
        }
    }

    @Override
    Color getColor(String colorType) {
        return null;
    }
}
