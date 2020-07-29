package com.option.behavioral.chain_of_responsibility.impl;

import com.option.behavioral.chain_of_responsibility.AbstractLogger;

public class FileLogger extends AbstractLogger {
    public FileLogger(int level){
        this.level = level;
    }
    @Override
    public void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
