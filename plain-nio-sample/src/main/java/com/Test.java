package com;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @Author: LJJ
 * @Program: plain-nio-sample
 * @Description:
 * @Create: 2020-05-05 13:22:22
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
//        Charset charset = Charset.forName("UTF-8");
//        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in action", charset);
//        ByteBuf slice = byteBuf.slice(0, 15);
//        System.out.println(slice.toString(charset));
//        byteBuf.setByte(0, (char)'J');
//        System.out.println(byteBuf.getByte(0) == slice.getByte(0));

        Charset charset = Charset.forName("UTF-8");
        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in action rocks!", charset);
        ByteBuf copy = byteBuf.copy(0, 15);
        System.out.println(copy.toString(charset));
        byteBuf.setByte(0, (char)'J');
        System.out.println(byteBuf.getByte(0) == copy.getByte(0));


    }
}
