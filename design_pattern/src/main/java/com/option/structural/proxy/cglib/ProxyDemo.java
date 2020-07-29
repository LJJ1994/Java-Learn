package com.option.structural.proxy.cglib;

public class ProxyDemo {
    public static void main(String[] args) {
        Engineer engineer = new Engineer();
        Engineer proxyEngineer = (Engineer) EngineerProxy.getProxy(engineer);
        proxyEngineer.eat();
        proxyEngineer.sleep();
    }
}
