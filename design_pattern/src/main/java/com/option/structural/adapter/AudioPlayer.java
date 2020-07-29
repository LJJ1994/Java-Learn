package com.option.structural.adapter;

import com.option.structural.adapter.service.MediaPlayer;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    public void play(String audioType, String filename) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Play mp3. name: " + filename);
        } else if (audioType.equalsIgnoreCase("vlc")
                || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, filename);
        } else {
            System.out.println("Invalid type: " + audioType + "format not support!");
        }
    }
}
