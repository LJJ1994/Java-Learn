package com.option.behavioral.strategy;

import com.option.behavioral.strategy.impl.OperationAdd;
import com.option.behavioral.strategy.impl.OperationMultiply;
import com.option.behavioral.strategy.impl.OperationSubtract;

public class StrategyDemo {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        Context context = new Context();

        context.setStrategy(new OperationAdd());
        System.out.println(context.executeStrategy(num1, num2));

        context.setStrategy(new OperationSubtract());
        System.out.println(context.executeStrategy(num1, num2));

        context.setStrategy(new OperationMultiply());
        System.out.println(context.executeStrategy(num1, num2));
    }
}
