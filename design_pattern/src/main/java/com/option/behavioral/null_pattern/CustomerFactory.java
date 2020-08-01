package com.option.behavioral.null_pattern;

import com.option.behavioral.null_pattern.impl.NullCustomer;
import com.option.behavioral.null_pattern.impl.RealCustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerFactory {
    private static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name) {
        if ("".equalsIgnoreCase(name)) {
            return new NullCustomer();
        }
        for (String s : names) {
            if (name.equalsIgnoreCase(s)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
