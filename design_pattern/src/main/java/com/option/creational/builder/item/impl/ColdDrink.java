package com.option.creational.builder.item.impl;

import com.option.creational.builder.item.Item;
import com.option.creational.builder.packing.Packing;
import com.option.creational.builder.packing.impl.Bottle;

public abstract class ColdDrink implements Item {
    public abstract String name();
    public abstract float price();

    public Packing pack() {
        return new Bottle();
    }
}
