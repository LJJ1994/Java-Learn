package main.java.core.innerclasses;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 14:43:43
 * @Modified By:
 */
public class DotThis {
    public void f(){
        System.out.println("DotThis.f()");
    }
    private class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        Inner inner = dotThis.inner();
        inner.outer().f();
    }
}
