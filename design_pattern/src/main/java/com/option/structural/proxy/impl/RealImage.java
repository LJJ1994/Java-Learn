package com.option.structural.proxy.impl;

import com.option.structural.proxy.Image;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk(filename);
    }

    @Override
    public void display() {
        System.out.println("Display Image : " + filename);
    }

    public void loadImageFromDisk(String filename) {
        System.out.println("Loading from disk: " + filename);
    }
}
