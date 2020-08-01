package com.option.behavioral.command;

import com.option.behavioral.command.impl.BuyStock;
import com.option.behavioral.command.impl.SellStock;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.playOrders();
    }
}
