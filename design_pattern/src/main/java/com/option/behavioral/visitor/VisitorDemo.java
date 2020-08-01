package com.option.behavioral.visitor;

import com.option.behavioral.visitor.impl.Computer;

public class VisitorDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
