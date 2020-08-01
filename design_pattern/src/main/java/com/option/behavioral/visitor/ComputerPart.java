package com.option.behavioral.visitor;

public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
