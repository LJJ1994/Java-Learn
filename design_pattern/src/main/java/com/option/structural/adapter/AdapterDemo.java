package com.option.structural.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "犯贱-徐良");
        audioPlayer.play("mp4", "十年-陈奕迅");
        audioPlayer.play("vlc", "欧若拉-张韶涵");
        audioPlayer.play("avi", "川香有菜.avi");
    }
}
