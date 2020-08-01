package com.option;

public class Sum {
    public static long sum() {
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sum01() {
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
//        sum();
        sum01();
        long end = System.nanoTime();
        System.out.println("wasted time: " + (end - start) / (1000 * 1000 * 1000));
    }
}
