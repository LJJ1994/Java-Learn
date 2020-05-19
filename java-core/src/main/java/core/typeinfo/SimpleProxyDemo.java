package main.java.core.typeinfo;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-20 19:58:58
 * @Modified By:
 */
interface Interface{
    void doSomething();
    void doSomethingElse(String args);
}

class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void doSomethingElse(String args) {
        System.out.println("do something else " + args);
    }
}

class SimpleProxy implements Interface{
    private Interface anInterface;

    public SimpleProxy(Interface itf){
        anInterface = itf;
    }

    @Override
    public void doSomething() {
        System.out.println("simple proxy do something");
        anInterface.doSomething();
    }

    @Override
    public void doSomethingElse(String args) {
        System.out.println("simple proxy do something else " + args);
        anInterface.doSomethingElse(args);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface itf){
        itf.doSomething();
        itf.doSomethingElse("booooo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println("================");
        consumer(new SimpleProxy(new RealObject()));
    }
}
