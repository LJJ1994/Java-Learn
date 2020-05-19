package main.java.core.strings;

import java.util.Formatter;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-15 23:40:40
 * @Modified By:
 */
public class Conversion {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);

        char u = 'a';
        System.out.println("u = 'a'");
        formatter.format("s: %s\n", u);
    }
}
