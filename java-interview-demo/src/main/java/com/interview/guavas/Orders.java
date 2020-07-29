package com.interview.guavas;

import com.google.common.base.Throwables;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public class Orders {
    public static void main(String[] args) {
        Ordering<String> ordering = new Ordering<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        };
        String s1 = "abc";
        String s2 = "de";
        int compare = ordering.compare(s1, s2);
        System.out.println(compare);

        Ordering<Comparable> natural = Ordering.natural();
        int compare1 = natural.compare(s1, s2);
        System.out.println(compare1);


    }
}
