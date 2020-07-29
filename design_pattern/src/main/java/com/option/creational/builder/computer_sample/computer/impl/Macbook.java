package com.option.creational.builder.computer_sample.computer.impl;

import com.option.creational.builder.computer_sample.computer.Computer;

public class Macbook extends Computer {
    public Macbook(){}

    @Override
    public void setOs() {
        mOs = "Mac OS X 12";
    }
}
