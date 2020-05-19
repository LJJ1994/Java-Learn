package main.java.core.innerclasses;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 16:38:38
 * @Modified By:
 */
interface Incrementable{
    void increment();
}

class Callee1 implements Incrementable{
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println("callee1 i = " + i);
    }
}

class MyIncrement{
    public void increment(){
        System.out.println("other operation");
    }
    static void f(MyIncrement m){
        m.increment();
    }
}

class Callee2 extends MyIncrement{
    private int i = 0;
    public void increment(){
        i++;
        System.out.println("callee2 i = " + i);
    }

    private class Closure implements Incrementable{

        @Override
        public void increment() {
            Callee2.this.increment(); // 当前Callee2对象的引用
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callerReference;
    Caller(Incrementable ih){
        callerReference = ih;
    }
    void go(){
        callerReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        MyIncrement.f(callee2);

        Caller caller1 = new Caller(callee1);
        Caller caller2 = new Caller(callee2.getCallbackReference()); // 使用回调
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
