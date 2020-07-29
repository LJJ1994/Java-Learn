package com.option.structural.adapter.service.impl;

import com.option.structural.adapter.service.AdvancedMediaPlayer;

public class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String filename) {

    }

    public void playMp4(String filename) {
        System.out.println("Play mp4, name: " + filename);
    }
}
