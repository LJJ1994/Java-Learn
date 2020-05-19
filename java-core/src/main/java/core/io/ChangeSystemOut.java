package main.java.core.io;

import java.io.PrintStream;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 12:10:10
 * @Modified By:
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out, true);
        printStream.println("hello world!");
    }
}
