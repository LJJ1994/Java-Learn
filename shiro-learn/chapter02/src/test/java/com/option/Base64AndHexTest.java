package com.option;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.junit.Test;

import java.util.Arrays;

public class Base64AndHexTest {
    @Test
    public void testBase64(){
        String str = "abc123";
        String encode = Base64.encodeToString(str.getBytes());
        String decode = Base64.decodeToString(encode);
        System.out.println(encode);
        System.out.println(decode);
        System.out.println(str.equals(decode));
    }

    @Test
    public void testHex(){
        String str = "abc123";
        String encode = Hex.encodeToString(str.getBytes());
        String decode = new String(Hex.decode(encode.getBytes()));
        System.out.println(encode);
        System.out.println(decode);
        System.out.println(str.equals(decode));
    }

    @Test
    public void testCodec(){
        String str = "abc123";
        byte[] bytes = CodecSupport.toBytes(str, "utf-8");
        String string = CodecSupport.toString(bytes, "utf-8");
        System.out.println(Arrays.toString(bytes));
        System.out.println(str);
        System.out.println(str.equals(string));
    }
}
