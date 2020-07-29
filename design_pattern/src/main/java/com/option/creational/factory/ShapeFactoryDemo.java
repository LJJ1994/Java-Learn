package com.option.creational.factory;

public class ShapeFactoryDemo {
    public static void main(String[] args) {
        Shape rectangle = ShapeFactory.getShape("Rectangle");
        assert rectangle != null;
        rectangle.draw();

        Shape circle = ShapeFactory.getShape("Circle");
        assert circle != null;
        circle.draw();

        Shape square = ShapeFactory.getShape("Square");
        assert square != null;
        square.draw();
    }
}
