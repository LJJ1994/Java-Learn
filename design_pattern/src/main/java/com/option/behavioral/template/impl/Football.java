package com.option.behavioral.template.impl;

import com.option.behavioral.template.Game;

public class Football extends Game {
    @Override
    public void initial() {
        System.out.println("football game initializing....");
    }

    @Override
    public void startPlay() {
        System.out.println("start football game......");
    }

    @Override
    public void endPlay() {
        System.out.println("end football game.....");
    }
}
