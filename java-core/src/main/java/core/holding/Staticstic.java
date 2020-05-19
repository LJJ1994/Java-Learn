package main.java.core.holding;

import java.util.HashMap;
import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 16:43:43
 * @Modified By:
 */
public class Staticstic {
    public static void main(String[] args) {
        Random random = new Random(47);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int nextInt = random.nextInt(100);
            Integer integer = map.get(nextInt);
            map.put(nextInt, integer == null ? 1 : integer + 1);
        }
        System.out.println(map);
    }
}
