package com.option.creational.prototype;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape shape = ShapeCache.getShape(1);
        System.out.println(shape);

    }
}
