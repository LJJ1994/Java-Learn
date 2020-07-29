package com.option.structural.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EngineerProxy implements MethodInterceptor {
    private Object target;

    public EngineerProxy(Object target) {
        this.target = target;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前........");
        Object invoke = method.invoke(target, objects);
        System.out.println("调用后.........");
        return invoke;
    }

    public static Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer(); // 增强器
        enhancer.setSuperclass(target.getClass()); // 被代理类
        enhancer.setCallback(new EngineerProxy(target)); //代理类
        return enhancer.create();
    }
}
