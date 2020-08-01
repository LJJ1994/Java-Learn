package com.option.java_design_pattern.front_controller;

import com.option.java_design_pattern.front_controller.view.AboutView;
import com.option.java_design_pattern.front_controller.view.HomeView;

public class Dispatcher {
    private HomeView homeView;
    private AboutView aboutView;

    public Dispatcher() {
        homeView = new HomeView();
        aboutView = new AboutView();
    }

    public void dispatch(String request) {
        if ("HOME".equalsIgnoreCase(request)) {
            homeView.show();
        } else if ("ABOUT".equalsIgnoreCase(request)){
            aboutView.show();
        } else {
            System.out.println("ERROR...");
        }
    }
}
