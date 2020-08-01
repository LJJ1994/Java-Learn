package com.option.behavioral.mediator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 充当中介者
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(dateForm(new Date())
                + " [" + user.getName() +"] : " + message);
    }

    private static String dateForm(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
