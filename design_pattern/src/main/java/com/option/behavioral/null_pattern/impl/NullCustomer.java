package com.option.behavioral.null_pattern.impl;

import com.option.behavioral.null_pattern.AbstractCustomer;

public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not available Customer";
    }
}
