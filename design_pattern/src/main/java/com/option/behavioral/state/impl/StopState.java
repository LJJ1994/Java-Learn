package com.option.behavioral.state.impl;

import com.option.behavioral.state.Context;
import com.option.behavioral.state.State;

public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state!");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}
