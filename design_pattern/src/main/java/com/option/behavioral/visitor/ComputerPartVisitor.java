package com.option.behavioral.visitor;

import com.option.behavioral.visitor.impl.Computer;
import com.option.behavioral.visitor.impl.Keyboard;
import com.option.behavioral.visitor.impl.Monitor;
import com.option.behavioral.visitor.impl.Mouse;

public interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Keyboard keyboard);
    void visit(Mouse mouse);
    void visit(Monitor monitor);
}
