package com.option.behavioral.chain_of_responsibility.impl;

import com.option.behavioral.chain_of_responsibility.AbstractLogger;

public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
