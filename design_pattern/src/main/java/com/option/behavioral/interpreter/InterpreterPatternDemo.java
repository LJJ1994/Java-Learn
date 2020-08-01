package com.option.behavioral.interpreter;

import com.option.behavioral.interpreter.impl.AndExpression;
import com.option.behavioral.interpreter.impl.OrExpression;
import com.option.behavioral.interpreter.impl.TerminalExpression;

public class InterpreterPatternDemo {
    public static Expression getMaleExpression() {
        Expression john = new TerminalExpression("John");
        Expression robert = new TerminalExpression("Robert");
        return new OrExpression(john, robert);
    }

    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpreter("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpreter("no Marrie Julie"));

    }
}
