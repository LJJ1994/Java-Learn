package com.itheima.ui;

import com.itheima.domain.iActor;
import com.itheima.domain.impl.ActorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: LJJ
 * @Program: spring-day02-actor
 * @Description:
 * @Create: 2020-05-07 19:40:40
 * @Modified By:
 */
public class Client {
    public static void main(String[] args) {
        final ActorImpl actor = new ActorImpl();
        iActor proxyActor = (iActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(),
                actor.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        Float money = (Float) args[0];
                        Object rtValue = null;
                        if ("basicAct".equals(name)){
                            if (money > 2000){
                                rtValue = method.invoke(actor, money/2);
                            }
                        }
                        if ("dangerAct".equals(name)){
                            if(money > 5000){
                                rtValue = method.invoke(actor, money / 2);
                            }
                        }
                        return rtValue;
                    }
                });
        System.out.println("基本方法调用");
        actor.basicAct(1000f);
        actor.dangerAct(4000f);
        System.out.println("增强后的方法");
        proxyActor.basicAct(8000f);
        proxyActor.dangerAct(50000f);
    }
}
