package com.option.behavioral.strategy.impl;

import com.option.behavioral.strategy.Strategy;

public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
