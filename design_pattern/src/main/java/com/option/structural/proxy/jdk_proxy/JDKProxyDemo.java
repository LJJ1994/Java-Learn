package com.option.structural.proxy.jdk_proxy;

import com.option.structural.proxy.jdk_proxy.impl.RealSubject;

import java.lang.reflect.Proxy;

public class JDKProxyDemo {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);

        System.out.println(proxySubject.sellBooks());
//        System.out.println(proxySubject.speak());
    }
}
