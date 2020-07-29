package com.option.structural.flyweight;

import com.option.structural.flyweight.impl.Circle;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String, Shape> cacheMap = new HashMap<>();

    public static Shape getShape(String color) {
        Circle circle = (Circle) cacheMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            cacheMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
