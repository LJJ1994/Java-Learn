package main.java.core.generics;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 08:39:39
 * @Modified By:
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder){
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static <T> void f2(Holder<?> holder){
        f1(holder);
    }

    public static void main(String[] args) {
        Holder holder = new Holder<Integer>(1);
        f1(holder);
        f2(holder);

        Holder raw = new Holder();
        raw.set(new Object());
        f2(raw);
        Holder<?> d = new Holder<Double>(1.0);
        f2(d);
    }
}
