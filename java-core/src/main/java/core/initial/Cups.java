package main.java.core.initial;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-11 13:53:53
 * @Modified By:
 */
class Cup{
    Cup(int maker){
        System.out.println("Cup(" + maker + ")");
    }
    void f(int maker){
        System.out.println("f(" + maker + ")");
    }
}

public class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups(){
        System.out.println("Cups()");
    }

    public static void main(String[] args) {
        Cups.cup1.f(99);
    }
}
