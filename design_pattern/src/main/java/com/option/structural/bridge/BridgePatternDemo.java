package com.option.structural.bridge;

import com.option.structural.bridge.impl.GreenCircle;
import com.option.structural.bridge.impl.RedCircle;
import com.option.structural.bridge.shape.Shape;
import com.option.structural.bridge.shape.impl.Circle;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(10, 10, 10, new RedCircle());
        Shape greenCircle = new Circle(11, 11, 11, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
