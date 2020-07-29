package com.interview.collections;

import java.util.*;

public class DemoList {
    public static void main(String[] args) {
        List<String> strings1 = new ArrayList<String>();
        strings1.add("go");
        strings1.add("home");
        strings1.add("my");
        strings1.add("son");
        System.out.println(strings1);
        System.out.println(strings1.contains("go"));
        System.out.println(strings1.isEmpty());
        System.out.println(strings1.size());
        System.out.println(strings1.subList(1,3));
        System.out.println(strings1.addAll(Arrays.asList("yes", "I", "will")));
        System.out.println(strings1);
        System.out.println(strings1.remove("go"));
        System.out.println(strings1);
        
    }
}
