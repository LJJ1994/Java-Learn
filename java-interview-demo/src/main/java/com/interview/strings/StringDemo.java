package com.interview.strings;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringDemo {
    public static void main(String[] args) {
        String s = "HELLO WORLD!";
        System.out.println(s.charAt(2));
        System.out.println(s.indexOf("W"));
        System.out.println(s.trim());
        System.out.println(s.codePointAt(2));
        System.out.println(s.lastIndexOf("L"));
        System.out.println(s.compareTo("HOME"));
        System.out.println(Arrays.toString(s.split(" ")));
        System.out.println(Arrays.toString(s.getBytes()));
        System.out.println(s.length());
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.substring(1));
        System.out.println("HELLO WORLD!".equals(s));

        String s1 = new String("HELLO WORLD!");
        System.out.println(s.equals(s1));

    }
}
