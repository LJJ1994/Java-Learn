package main.java.core.containers;

import net.mindview.util.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 00:48:48
 * @Modified By:
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<>(new CountingMapData(10));
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println("low: " +low);
        System.out.println("high: " + high);
        Iterator<Integer> iterator = sortedMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) low = iterator.next();
            if (i == 6) high = iterator.next();
            else iterator.next();
        }
        System.out.println(low);
        System.out.println(high);
    }
}
