package com.option.creational.singleton;

public class SingleObjectDemo {
    public static void main(String[] args) {
        SingleObject instance = SingleObject.getInstance();
        instance.showMessage();
        SingleObject instance01 = SingleObject.getInstance();
        System.out.println(instance == instance01);
    }
}
