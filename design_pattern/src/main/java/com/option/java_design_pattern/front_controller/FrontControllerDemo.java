package com.option.java_design_pattern.front_controller;

public class FrontControllerDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatch("HOME");
        System.out.println("=============");
        frontController.dispatch("ABOUT");
        System.out.println("================");
        frontController.dispatch("error");
    }
}
