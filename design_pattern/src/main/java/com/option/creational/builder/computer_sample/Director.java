package com.option.creational.builder.computer_sample;

public class Director {
    private Builder mBuilder = null;
    public Director(Builder builder) {
        this.mBuilder = builder;
    }

    public void construct(String mDisplay, String mBoard) {
        mBuilder.buildBoard(mBoard);
        mBuilder.buildDisplay(mDisplay);
        mBuilder.buildOs();
    }
}
