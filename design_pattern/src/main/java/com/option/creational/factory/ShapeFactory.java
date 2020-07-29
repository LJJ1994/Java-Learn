package com.option.creational.factory;

import com.option.creational.factory.impl.Circle;
import com.option.creational.factory.impl.Rectangle;
import com.option.creational.factory.impl.Square;

public class ShapeFactory {
    public static Shape getShape(String shapeType){
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
}
