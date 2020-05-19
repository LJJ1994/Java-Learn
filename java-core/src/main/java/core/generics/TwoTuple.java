package main.java.core.generics;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-20 22:36:36
 * @Modified By:
 */
public class TwoTuple<A, B> {
    public final A a;
    public final B b;
    public TwoTuple(A a, B b){
        this.a = a;
        this.b = b;
    }
    public String toString(){
        return "(" + a + "," + b + ")";
    }

    public static void main(String[] args) {
        TwoTuple<Integer, String> tuple = new TwoTuple<>(1, "ljj");
        System.out.println(tuple);
    }
}
