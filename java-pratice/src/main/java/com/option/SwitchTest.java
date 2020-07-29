package com.option;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.ThreadPoolExecutor;

public class SwitchTest {
    private static int switchInt(int i){
        int j = 1;
        switch (i){
            case 1:j++;
            case 2:j++;
            case 3:j++;
            case 4:j++;
            case 5:j++;
            default:j++;
        }
        return i+j;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String decode = URLDecoder.decode("%E5%A4%A9%E6%B4%A5%E5%A4%A7%E5%AD%A6+Rico", "UTF-8");
        System.out.println(decode);
        String encode = URLEncoder.encode("凌家杰 gohome!", "UTF-8");
        System.out.println(encode);
    }
}
