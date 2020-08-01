package com.option.behavioral.interpreter.impl;

import com.option.behavioral.interpreter.Expression;

public class AndExpression implements Expression {
    private Expression expression01;
    private Expression expression02;

    public AndExpression(Expression expression01, Expression expression02) {
        this.expression01 = expression01;
        this.expression02 = expression02;
    }

    @Override
    public boolean interpreter(String content) {
        return expression01.interpreter(content) && expression02.interpreter(content);
    }
}
