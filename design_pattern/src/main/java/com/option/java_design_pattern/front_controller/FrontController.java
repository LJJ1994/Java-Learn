package com.option.java_design_pattern.front_controller;

public class FrontController {
    private Dispatcher dispatcher;
    public FrontController() {
        dispatcher = new Dispatcher();
    }

    private boolean isAuthenticated(String request) {
        System.out.println("Authenticated successful!: " + request);
        return true;
    }

    private void traceRequest(String request) {
        System.out.println("Trace Request: " + request);
    }

    public void dispatch(String request) {
        traceRequest(request);
        if (isAuthenticated(request)) {
            dispatcher.dispatch(request);
        }
    }
}
