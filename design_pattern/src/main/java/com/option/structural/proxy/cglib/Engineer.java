package com.option.structural.proxy.cglib;

public class Engineer {
    public void eat() {
        System.out.println("工程师正在吃饭.........");
    }

    public final void sleep() {
        System.out.println("工程师正在睡觉............");
    }

    private void work() {
        System.out.println("工程师正在工作............");
    }
}
