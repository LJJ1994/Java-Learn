package com.option.structural.proxy.jdk_proxy;

import com.option.structural.proxy.jdk_proxy.impl.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Subject realSubject;

    public MyInvocationHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类....");
        if (method.getName().equalsIgnoreCase("sellBooks")) {
            int invoke = (int) method.invoke(realSubject, args);
            System.out.println("调用sellBooks方法，并且增强了。");
            return invoke + 2;
        }else {
            String say = (String) method.invoke(realSubject, args);
            System.out.println("调用speak方法，并且增强了。");
            return say.concat("Good Bye!");
        }
    }
}
