package com.sample.encode;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @Author: LJJ
 * @Program: plain-nio-sample
 * @Description:
 * @Create: 2020-05-05 23:36:36
 * @Modified By:
 */
public class AbsIntegerEncoderTest {
    @Test
    public void testEncoded(){
        ByteBuf buff = Unpooled.buffer();
        for (int i = 0; i < 10; i++) {
            buff.writeInt(i * -1);
        }
        EmbeddedChannel channel = new EmbeddedChannel(new AbsIntegerEncoder());
        assertTrue(channel.writeOutbound(buff));
        assertTrue(channel.finish());

        for (int i = 0; i < 10; i++) {
            assertEquals(i, channel.readOutbound());
        }
        assertNull(channel.readOutbound());
    }
}
