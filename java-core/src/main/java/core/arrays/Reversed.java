package main.java.core.arrays;

import net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 08:16:16
 * @Modified By:
 */
public class Reversed {
    public static void main(String[] args) {
        CompType[] array = Generated.array(new CompType[6], CompType.generator());
        System.out.println("before sort");
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("after sort");
        System.out.println(Arrays.toString(array));
    }
}
