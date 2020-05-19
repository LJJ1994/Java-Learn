package main.java.core.containers;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-27 09:14:14
 * @Modified By:
 */
public class Sychronization {
    public static void main(String[] args) {
        List<String> c = Collections.synchronizedList(new ArrayList<String>());
        Collection<String> s = Collections.synchronizedCollection(new ArrayList<String>());
        Set<String> ss = Collections.synchronizedSet(new HashSet<String>());
        Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
        SortedMap<Object, Object> sortedMap = Collections.synchronizedSortedMap(new TreeMap<>());
    }
}
