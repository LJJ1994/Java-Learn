package com.itheima.ui;

import com.itheima.domain.Actor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: LJJ
 * @Program: spring-day02-actor
 * @Description:
 * @Create: 2020-05-07 19:48:48
 * @Modified By:
 */
public class Client1 {
    public static void main(String[] args) {
        final Actor actor = new Actor();
        Actor proxyActor = (Actor) Enhancer.create(actor.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object rtValue = null;
                String name = method.getName();
                Float money = (Float) objects[0];
                if ("basicAct".equals(name)){
                    if (money > 2000){
                        rtValue = method.invoke(actor, money);
                    }
                }
                if ("dangerAct".equals(name)){
                    if (money > 5000){
                        rtValue = method.invoke(actor, money);
                    }
                }
                return rtValue;
            }
        });
        proxyActor.basicAct(3000f);
        proxyActor.dangerAct(10000f);
    }
}
