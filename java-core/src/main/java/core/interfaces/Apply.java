package main.java.core.interfaces;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-12 18:55:55
 * @Modified By:
 */
public class Apply {
    public static void process(Processor p, Object o){
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(o));
    }
}
