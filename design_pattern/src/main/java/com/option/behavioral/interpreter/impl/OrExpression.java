package com.option.behavioral.interpreter.impl;

import com.option.behavioral.interpreter.Expression;

public class OrExpression implements Expression {
    private Expression expr01;
    private Expression expr02;

    public OrExpression(Expression expr01, Expression expr02) {
        this.expr01 = expr01;
        this.expr02 = expr02;
    }

    @Override
    public boolean interpreter(String content) {
        return expr01.interpreter(content) || expr02.interpreter(content);
    }
}
