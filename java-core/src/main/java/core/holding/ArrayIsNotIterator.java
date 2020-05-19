package main.java.core.holding;

import java.util.Arrays;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 18:18:18
 * @Modified By:
 */
public class ArrayIsNotIterator {
    private static <T> void test(Iterable<T> iterable){
        for(T t : iterable){
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"a", "b", "c"};
        test(Arrays.asList(strings));
    }
}
