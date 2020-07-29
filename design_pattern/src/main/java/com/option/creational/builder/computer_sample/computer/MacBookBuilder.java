package com.option.creational.builder.computer_sample.computer;

import com.option.creational.builder.computer_sample.Builder;
import com.option.creational.builder.computer_sample.computer.impl.Macbook;

public class MacBookBuilder extends Builder {
    private Computer macbook = new Macbook();
    public void buildDisplay(String display) {
        macbook.setDisplay(display);
    }

    public void buildBoard(String board) {
        macbook.setBoard(board);
    }

    public void buildOs() {
        macbook.setOs();
    }

    public Computer build() {
        return macbook;
    }
}
