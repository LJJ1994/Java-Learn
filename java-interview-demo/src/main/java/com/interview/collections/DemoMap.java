package com.interview.collections;

import java.util.HashMap;
import java.util.Map;

public class DemoMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("d", "dd");
        System.out.println(map);
        System.out.println(map.get("c"));
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue("aa"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.values());

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        for (String s : map.keySet()) {
            System.out.println(s + "----> " + map.get(s));
        }
        map.replace("a", "a0");
        System.out.println(map.values());
        map.clear();
        System.out.println(map);

        map.put(null, "a");
        map.put(null, "a0");
        map.put(null, "a1");
        System.out.println(map);
        System.out.println(map.get(null));
        System.out.println("===========");
        map.put("", "b");
        map.put("", "c");
        map.put("", "d");
        System.out.println(map);
        System.out.println(map.get(""));
    }
}
