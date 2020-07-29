package com.option.structural.decorator;

public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    public void draw(){
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    public void setRedBorder(Shape decoratedShape){
        System.out.println(decoratedShape + " Border color: Red!");
    }
}
