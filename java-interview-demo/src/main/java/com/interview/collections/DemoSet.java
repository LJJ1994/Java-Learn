package com.interview.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DemoSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("A");
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        System.out.println(strings);
        System.out.println(strings.contains("a"));
        System.out.println(strings.contains("aa"));
        System.out.println(strings.isEmpty());
        System.out.println(strings.remove("d"));
        System.out.println(strings);
        System.out.println(strings.size());
        System.out.println(Arrays.toString(strings.toArray()));


    }
}
