package com.option.behavioral.template.impl;

import com.option.behavioral.template.Game;

public class Basketball extends Game {
    @Override
    public void initial() {
        System.out.println("basketball game initializing....");
    }

    @Override
    public void startPlay() {
        System.out.println("start basketball game.....");
    }

    @Override
    public void endPlay() {
        System.out.println("end basketball game......");
    }
}
