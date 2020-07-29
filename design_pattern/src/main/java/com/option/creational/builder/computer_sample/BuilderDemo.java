package com.option.creational.builder.computer_sample;

import com.option.creational.builder.computer_sample.computer.Computer;
import com.option.creational.builder.computer_sample.computer.MacBookBuilder;

public class BuilderDemo {
    public static void main(String[] args) {
        Builder macBookBuilder = new MacBookBuilder();
        Director director = new Director(macBookBuilder);
        director.construct("英特尔显示器", "樱桃键盘");
        Computer computer = macBookBuilder.build();
        System.out.println(computer.toString());
    }
}
