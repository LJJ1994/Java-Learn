package main.java.core.containers;

import java.util.LinkedHashMap;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 01:09:09
 * @Modified By:
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(map);
        map = new LinkedHashMap<Integer, String>(16, 0.75f, true);
        map.putAll(new CountingMapData(9));
        for (int i = 0; i < 6; i++) {
            map.get(i);
        }
        System.out.println(map);
        map.get(0);
        System.out.println(map);
    }
}
