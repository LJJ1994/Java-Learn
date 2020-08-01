package com.option.behavioral.visitor.impl;

import com.option.behavioral.visitor.ComputerPart;
import com.option.behavioral.visitor.ComputerPartVisitor;

public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
