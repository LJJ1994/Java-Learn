package com.interview.pracatice;

public interface PlayManager {
    /**
     * 添加玩家
     * @param player
     */
    void addPlayer(Player player);

    /**
     * 根据用户名获取玩家
     * @param username
     * @return
     */
    Player getPlayer(String username);

    /**
     * 向玩家广播消息
     * @param message
     */
    void broadcast(String message);
}
