package com.option.structural.decorator;

import com.option.structural.decorator.impl.Circle;
import com.option.structural.decorator.impl.Square;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Circle circle = new Circle();

        RedShapeDecorator circleRedDecorator = new RedShapeDecorator(new Circle());
        RedShapeDecorator squareRedDecorator = new RedShapeDecorator(new Square());

        circle.draw();
        System.out.println("========================================");
        circleRedDecorator.draw();
        System.out.println("========================================");
        squareRedDecorator.draw();
    }
}
