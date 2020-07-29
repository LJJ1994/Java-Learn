package com.option.creational.abstract_factory;

public class FactoryProducer {
    public static AbstractFactory getAbstractFactory(String choice) {
        if (null == choice){
            return null;
        }
        if (choice.equalsIgnoreCase("Shape")) {
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("Color")) {
            return new ColorFactory();
        }else{
            return null;
        }
    }
}
