package com.option.java_design_pattern.filter.impl;

import com.option.java_design_pattern.filter.Filter;

public class AuthenticateFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticate request: " + request);
    }
}
