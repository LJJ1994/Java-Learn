package main.java.core.generics;

import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 11:19:19
 * @Modified By:
 */
class FArray{
    public static <T> T[] fill(T[] a, Generator<T> generator){
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.next();
        }
        return a;
    }
}
public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7], new RandomGenerator.String(10));
        for (String string : strings) {
            System.out.println(string);
        }
        Integer[] integers = FArray.fill(new Integer[10], new RandomGenerator.Integer());
        for (int integer : integers) {
            System.out.println(integer);
        }

//        int[] b = FArray.fill(new int[7], new RandomGenerator.Integer());
    }
}
