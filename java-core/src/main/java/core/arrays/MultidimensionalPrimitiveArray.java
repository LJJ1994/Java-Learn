package main.java.core.arrays;

import java.util.Arrays;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 23:28:28
 * @Modified By:
 */
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(Arrays.deepToString(a));
        System.out.println(a[0][2]);

        int[][][] b = new int[2][2][4];
        System.out.println(Arrays.deepToString(b));

        Integer[][] c;
        c = new Integer[3][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new Integer[3];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(c));
    }
}
