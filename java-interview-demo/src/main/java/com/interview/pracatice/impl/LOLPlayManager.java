package com.interview.pracatice.impl;

import com.interview.pracatice.PlayManager;
import com.interview.pracatice.Player;

import java.util.ArrayList;
import java.util.List;

public class LOLPlayManager implements PlayManager {
    private static List<Player> playerList = new ArrayList<>();

    @Override
    synchronized public void addPlayer(Player player) {
        playerList.add(player);
    }

    @Override
    synchronized public Player getPlayer(String username) {
        if ("".equals(username)){
            throw new RuntimeException("用户名不能为空");
        }
        for (Player player : playerList) {
            if (username.equals(player.getUsername())) {
                return player;
            }
        }
        return null;
    }

    @Override
    public void broadcast(String message) {
        synchronized (this) {
            for (Player player : playerList) {
                player.write(message);
            }
        }
    }
}
