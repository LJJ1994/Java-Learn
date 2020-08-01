package com.option.java_design_pattern.filter;

import com.option.java_design_pattern.filter.impl.AuthenticateFilter;
import com.option.java_design_pattern.filter.impl.DebugFilter;
import com.option.java_design_pattern.filter.impl.Target;

public class InterceptingFilterDemo {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticateFilter());
        filterManager.setFilter(new DebugFilter());

        Client client = new Client(filterManager);
        client.sendRequest("HOME");

    }
}
