package main.java.core.typeinfo;

import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-20 15:41:41
 * @Modified By:
 */
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialzation.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }

}
class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}
class Initable3{
    static int staticNonFinale = 74; // 非常数静态域(非final)
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialzation {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("after initialing..");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println("==========================");
        System.out.println(Initable2.staticNonFinal);
        System.out.println("=============================");
        Class initable3 = Class.forName("main.java.core.typeinfo.Initable3");
        System.out.println("after creating Initable3 ref..");
        System.out.println(Initable3.staticNonFinale);
    }
}
