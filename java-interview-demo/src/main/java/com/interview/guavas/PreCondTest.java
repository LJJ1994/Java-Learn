package com.interview.guavas;

import com.google.common.base.Preconditions;

import java.util.Objects;

public class PreCondTest {
    public static void main(String[] args) {
        boolean flag = true;
        Preconditions.checkArgument(flag);
//        Preconditions.checkElementIndex(21, 20, "index is not valid");
        Preconditions.checkState(flag, "Object: %s state is not valid! ", "abc");
        String s = "a";
        Preconditions.checkNotNull(s);
        String s1 = Objects.requireNonNull(s);
        System.out.println(s1);
    }
}
