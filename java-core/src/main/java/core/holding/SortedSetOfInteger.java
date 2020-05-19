package main.java.core.holding;

import java.util.Random;
import java.util.TreeSet;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 16:26:26
 * @Modified By:
 */
public class SortedSetOfInteger {
    public static void main(String[] args) {
        TreeSet<Integer> integers = new TreeSet<>();
        Random random = new Random(47);
        for (int i = 0; i < 10000; i++) {
            integers.add(random.nextInt(200));
        }
        System.out.println(integers);
    }
}
