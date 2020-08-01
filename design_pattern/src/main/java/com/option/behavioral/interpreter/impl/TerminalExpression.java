package com.option.behavioral.interpreter.impl;

import com.option.behavioral.interpreter.Expression;

public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpreter(String content) {
        if (content.contains(data)) {
            return true;
        }
        return false;
    }
}
