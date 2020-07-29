package com.interview.pracatice.impl;

import com.interview.pracatice.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        //启动10个线程添加用户
        LOLPlayManager lolPlayManager = new LOLPlayManager();
        for (int i = 0; i < 10; i++) {
            LOLPlayer lolPlayer = new LOLPlayer("召唤师" + i, true);
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    lolPlayManager.addPlayer(lolPlayer);
                }
            };
            executorService.execute(task);
        }

        //测试根据username获取play
        System.out.println("===========================");
        String username = "召唤师1";
        Player player = lolPlayManager.getPlayer(username);
        System.out.println(player);

        //测试广播所有用户
        System.out.println("============================");
        String message = "我五杀辣！！";
        lolPlayManager.broadcast(message);
    }
}
