package com.option.structural.bridge.impl;

import com.option.structural.bridge.DrawAPI;

/**
 * 实现了桥接API的实现类
 */
public class RedCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
