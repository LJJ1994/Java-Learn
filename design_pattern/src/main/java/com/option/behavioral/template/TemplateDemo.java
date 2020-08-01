package com.option.behavioral.template;

import com.option.behavioral.template.impl.Basketball;
import com.option.behavioral.template.impl.Football;

public class TemplateDemo {
    public static void main(String[] args) {
        Game football = new Football();
        football.play();

        Game basketball = new Basketball();
        basketball.play();
    }
}
