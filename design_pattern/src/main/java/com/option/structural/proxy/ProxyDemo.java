package com.option.structural.proxy;

import com.option.structural.proxy.impl.RealImage;

public class ProxyDemo {
    public static void main(String[] args) {
        Image proxyImage = new ProxyImage("test.png");
        proxyImage.display();
        System.out.println("=========================");
        proxyImage.display();
    }
}
