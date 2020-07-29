package com.interview.guavas;

import com.google.common.collect.*;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class collections {
    public static void main(String[] args) {
        ImmutableSet<Integer> set = ImmutableSet.of(1,2,3,4,5);
        for (Integer integer : set) {
            System.out.println(integer);
        }
        System.out.println("====================");

        ImmutableSet<Object> build = ImmutableSet.builder().add("a").add("b").add(1).build();
        for (Object o : build) {
            System.out.println(o);
        }
        ImmutableList<Object> objects = build.asList();
        System.out.println(objects.get(1));
        System.out.println("===============");

        String string = "A B C D A A B";
        String[] strings = string.split(" ");
        HashMultiset<String> strings1 = HashMultiset.create();
        strings1.addAll(Arrays.asList(strings));
        System.out.println("A: " + strings1.count("A"));
        System.out.println("B: " + strings1.count("B"));

        HashMultimap<Object, Object> multimap = HashMultimap.create();
        multimap.put("a", 1);
        multimap.put("b", 2);
        multimap.put("c", 3);
        multimap.put("a", 4);
        System.out.println(multimap.containsKey("a"));
        System.out.println(multimap.keys());
        System.out.println(multimap.get("a"));
        Set<Map.Entry<Object, Object>> entries = multimap.entries();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Collection<Object> a = multimap.asMap().get("a");
        System.out.println(a);
        System.out.println(multimap.asMap().get("c"));

        System.out.println(multimap.keySet());
        System.out.println(multimap.keys());
        System.out.println(multimap.values());
        System.out.println(multimap.asMap().values());

        HashBiMap<Object, Object> biMap = HashBiMap.create();
        biMap.put("bob", 41);
        biMap.put(41, "bob");
        biMap.putIfAbsent("bob1", 42);
        Object o = biMap.inverse().get("bob");
        System.out.println(o);
        System.out.println(biMap.values());



    }
}
