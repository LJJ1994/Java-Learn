package com.option.behavioral.command.impl;

import com.option.behavioral.command.Order;
import com.option.behavioral.command.Stock;

public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }
    @Override
    public void execute() {
        abcStock.buy();
    }
}
