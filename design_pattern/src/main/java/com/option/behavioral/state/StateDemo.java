package com.option.behavioral.state;

import com.option.behavioral.state.impl.StartState;
import com.option.behavioral.state.impl.StopState;

public class StateDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState());

        System.out.println("================================");

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState());
    }
}
