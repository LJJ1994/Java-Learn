package com.option.creational.builder.computer_sample;

import com.option.creational.builder.computer_sample.computer.Computer;

public abstract class Builder {
    public abstract void buildDisplay(String display);
    public abstract void buildBoard(String board);
    public abstract void buildOs();
    public abstract Computer build();
}
