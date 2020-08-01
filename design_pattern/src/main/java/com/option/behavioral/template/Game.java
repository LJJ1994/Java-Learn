package com.option.behavioral.template;

public abstract class Game {
    public abstract void initial();
    public abstract void startPlay();
    public abstract void endPlay();

    public final void play() {
        initial();
        startPlay();
        endPlay();
    }
}
