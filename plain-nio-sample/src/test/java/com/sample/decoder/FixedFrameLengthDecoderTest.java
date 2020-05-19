package com.sample.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @Author: LJJ
 * @Program: plain-nio-sample
 * @Description:
 * @Create: 2020-05-05 23:10:10
 * @Modified By:
 */
public class FixedFrameLengthDecoderTest {
    @Test
    public void testFrameDecoder(){
        ByteBuf buff = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buff.writeByte(i);
        }

        ByteBuf input = buff.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        System.out.println(channel.writeInbound(input.retain()));
        System.out.println(channel.finish());

        ByteBuf read = (ByteBuf) channel.readInbound();
        assertEquals(buff.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buff.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buff.readSlice(3), read);
        read.release();

        assertNull(channel.readInbound());
        buff.release();
    }

    @Test
    public void testFrameDecoder2(){
        ByteBuf buff = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buff.writeByte(i);
        }
        ByteBuf input = buff.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        assertFalse(channel.writeInbound(input.readBytes(2)));
        assertTrue(channel.writeInbound(input.readBytes(7)));

        assertTrue(channel.finish());
        ByteBuf read = (ByteBuf) channel.readInbound();
        assertEquals(buff.readSlice(3), read);
        read.release();
        read = (ByteBuf) channel.readInbound();
        assertEquals(buff.readSlice(3), read);
        read.release();
        read = (ByteBuf) channel.readInbound();
        assertEquals(buff.readSlice(3), read);
        read.release();
        assertNull(channel.readInbound());
        buff.release();
    }
}
