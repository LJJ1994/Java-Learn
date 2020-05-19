package com;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.util.ReferenceCounted;

import java.nio.channels.Channel;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @Author: LJJ
 * @Program: plain-nio-sample
 * @Description:
 * @Create: 2020-05-05 13:30:30
 * @Modified By:
 */
public class Test1 {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        System.out.println((char)buf.getByte(0));

        int readIndex = buf.readerIndex();
        int writeIndex = buf.writerIndex();
        buf.setByte(0, (byte)'B');
        System.out.println((char) buf.getByte(0));
        System.out.println(readIndex == buf.readerIndex());
        System.out.println(writeIndex == buf.writerIndex());

        System.out.println(buf.maxCapacity());
        System.out.println(buf.capacity());
        System.out.println(buf.hasArray());
        System.out.println(Arrays.toString(buf.array()));

    }
}
