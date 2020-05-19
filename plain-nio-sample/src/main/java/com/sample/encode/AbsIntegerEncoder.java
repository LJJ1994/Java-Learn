package com.sample.encode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: plain-nio-sample
 * @Description:
 * @Create: 2020-05-05 23:34:34
 * @Modified By:
 */
public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        while (in.readableBytes() >= 4){
            int i = Math.abs(in.readInt());
            list.add(i);
        }
    }
}
