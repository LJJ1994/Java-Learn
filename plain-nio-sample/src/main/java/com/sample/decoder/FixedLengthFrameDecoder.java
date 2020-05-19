package com.sample.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: plain-nio-sample
 * @Description:
 * @Create: 2020-05-05 23:04:04
 * @Modified By:
 */
public class FixedLengthFrameDecoder extends ByteToMessageDecoder {
    private final int length;
    public FixedLengthFrameDecoder(int length){
        if (length <= 0){
            throw new IllegalArgumentException("frame length must be a positive integer : " + length);
        }
        this.length = length;
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
            while (byteBuf.readableBytes() >= length){
                ByteBuf b = byteBuf.readBytes(length);
                list.add(b);
            }
    }
}
