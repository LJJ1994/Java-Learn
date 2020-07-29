package com.option.behavioral.chain_of_responsibility.impl;

import com.option.behavioral.chain_of_responsibility.AbstractLogger;

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
