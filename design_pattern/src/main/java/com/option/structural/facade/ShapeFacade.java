package com.option.structural.facade;

import com.option.structural.facade.impl.Circle;
import com.option.structural.facade.impl.Rectangle;
import com.option.structural.facade.impl.Square;

public class ShapeFacade {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeFacade() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }

    public void drawSquare(){
        square.draw();
    }
}
