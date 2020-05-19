package main.java.core.innerclasses;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 14:46:46
 * @Modified By:
 */
public class DoNew {
    public class Inner{}

    public static void main(String[] args) {
        DoNew doNew = new DoNew();
        Inner inner = doNew.new Inner();
    }
}
