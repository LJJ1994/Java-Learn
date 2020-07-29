package com.option.structural.adapter;

import com.option.structural.adapter.service.AdvancedMediaPlayer;
import com.option.structural.adapter.service.MediaPlayer;
import com.option.structural.adapter.service.impl.Mp4Player;
import com.option.structural.adapter.service.impl.VlcPlayer;

public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new VlcPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String filename) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playVlc(filename);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playMp4(filename);
        }
    }
}
