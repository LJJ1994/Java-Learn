package com.option.behavioral.visitor;

import com.option.behavioral.visitor.impl.Computer;
import com.option.behavioral.visitor.impl.Keyboard;
import com.option.behavioral.visitor.impl.Monitor;
import com.option.behavioral.visitor.impl.Mouse;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("Display computer");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Display keyboard");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Display mouse");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Display monitor");
    }
}
