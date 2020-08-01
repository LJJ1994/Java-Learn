package com.option.behavioral.command.impl;

import com.option.behavioral.command.Order;
import com.option.behavioral.command.Stock;

public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
