package main.java.core.strings;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-16 00:15:15
 * @Modified By:
 */
public class IntegerMatches {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("-199".matches("([-+])?\\d+"));
    }
}
