package main.java.core.concurrency;

import net.mindview.atunit.Test;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-10 22:43:43
 * @Modified By:
 */
public class TestInt {
    char c;
    Test i;
    public void printInitial(){
        System.out.println("[" + c + "]");
        System.out.println(i);
    }
    public static void main(String[] args) {
        TestInt t = new TestInt();
        t.printInitial();
    }
}
