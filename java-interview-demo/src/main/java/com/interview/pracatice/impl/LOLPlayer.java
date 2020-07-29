package com.interview.pracatice.impl;

import com.interview.pracatice.Player;

import java.util.concurrent.atomic.AtomicInteger;

public class LOLPlayer implements Player {
    private static long counter = 0;
    private long id = counter++;
    private String username;
    private boolean offline;
    private String message;

    public LOLPlayer(String username, boolean offline){
        this.username = username;
        this.offline = offline;
    }

    private LOLPlayer(){}

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 向玩家发送消息
     * @param message
     */
    @Override
    public void write(String message) {
        this.message = message;
        System.out.println("[" + id + "]" + " 获取了: " + message);
    }

    @Override
    public boolean isOffline() {
        return offline;
    }

    @Override
    public String toString() {
        return "LOLPlayer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", offline=" + offline +
                ", message='" + message + '\'' +
                '}';
    }
}
