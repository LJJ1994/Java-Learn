package com;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoop;

import java.util.concurrent.TimeUnit;

/**
 * @Author: LJJ
 * @Program: plain-nio-sample
 * @Description:
 * @Create: 2020-05-05 15:36:36
 * @Modified By:
 */
public class Test2 {
    public static void main(String[] args) {
        Channel channel = null;
        channel.eventLoop().scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("10 seconds later..");
            }
        }, 2, 10, TimeUnit.SECONDS);
    }
}
