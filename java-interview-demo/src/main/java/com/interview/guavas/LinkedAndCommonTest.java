package com.interview.guavas;

import java.util.*;

public class LinkedAndCommonTest {
    public static long putCompute(List list){
        long start = System.nanoTime();
        for (int i = 0; i < 4000000; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        System.out.println(putCompute(arrayList));
        List<Integer> linkedList = new LinkedList<>();
        System.out.println(putCompute(linkedList));
    }
}
