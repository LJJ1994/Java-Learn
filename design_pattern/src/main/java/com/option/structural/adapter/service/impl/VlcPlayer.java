package com.option.structural.adapter.service.impl;

import com.option.structural.adapter.service.AdvancedMediaPlayer;

public class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String filename) {
        System.out.println("Play vlc, name: " + filename);
    }

    public void playMp4(String filename) {

    }
}
