package com.interview.pracatice;

public interface Player {
    /**
     * 获取用户名
     * @return
     */
    String getUsername();

    /**
     * 向玩家发送消息
     * @param message
     */
    void write(String message);

    /**
     * 玩家是否离线
     * @return
     */
    boolean isOffline();
}
