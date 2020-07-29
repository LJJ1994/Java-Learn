package com.option.creational.builder.item;

import com.option.creational.builder.packing.Packing;

public interface Item {
    String name();
    float price();
    Packing pack();
}
