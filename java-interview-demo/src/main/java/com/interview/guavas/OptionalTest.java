package com.interview.guavas;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;

public class OptionalTest {
    public static void main(String[] args) {
        String s = "abc";
//        Optional<String> optional = Optional.of(s);
//        System.out.println(optional.get());
//        System.out.println(optional.isPresent());

//        Optional<String> optional = Optional.of(s);
//        System.out.println(optional.get());
//        Optional<Object> absent = Optional.absent();
//        System.out.println(absent);
//        String s1 = null;
//        Optional<String> stringOptional = Optional.fromNullable(s1);
//        System.out.println(stringOptional);
//        String s2 = "a";
//        Optional<String> of = Optional.fromNullable(s2);
//        System.out.println(of.or("ABC"));
//        System.out.println(of.asSet());

//        String s1 = Strings.emptyToNull("");
//        String s2 = Strings.nullToEmpty(null);
//        System.out.println(s1);
//        System.out.println("s2:" + s2 + "s2");

        String s3 = null;
        String s4 = "";
        if (Strings.isNullOrEmpty(s3) && Strings.isNullOrEmpty(s4)){
            System.out.println("true");
        }

    }
}
