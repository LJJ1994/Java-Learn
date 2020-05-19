package main.java.core.containers;

import net.mindview.util.CountingMapData;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 00:32:32
 * @Modified By:
 */
public class Maps {
    public static void printKeys(Map<Integer, String> map){
        System.out.println("map.size() " + map.size());
        System.out.println("keys: ");
        System.out.println(map.keySet());
    }

    public static void test(Map<Integer, String> map){
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        printKeys(map);
        System.out.println("Values():");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11) " + map.containsKey(11));
        System.out.println("map.get(11) " + map.get(11));
        System.out.println("map.containsValue(\"F0\") " + map.containsValue("F0"));
        Iterator<Integer> iterator = map.keySet().iterator();
        Integer first = iterator.next();
        System.out.println("First key: " + first);
        map.remove(first);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty() " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty() " + map.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println("---------HashMap----------------");
        test(new HashMap<>());
        System.out.println("---------TreeMap----------------");
        test(new TreeMap<Integer, String>());
        System.out.println("---------LinkedHashMap----------------");
        test(new LinkedHashMap<Integer, String>());
    }
}
