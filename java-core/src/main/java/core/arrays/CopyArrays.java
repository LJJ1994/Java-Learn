package main.java.core.arrays;

import java.util.Arrays;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 07:48:48
 * @Modified By:
 */
public class CopyArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i: " + Arrays.toString(i));
        System.out.println("j: " +Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j= " + Arrays.toString(j));
    }
}
