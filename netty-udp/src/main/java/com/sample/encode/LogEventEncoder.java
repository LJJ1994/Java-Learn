package com.sample.encode;

import com.sample.domain.EventLog;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: netty-udp
 * @Description:
 * @Create: 2020-05-06 21:47:47
 * @Modified By:
 */
public class LogEventEncoder extends MessageToMessageEncoder<EventLog> {
    private InetSocketAddress remoteAddress;
    public LogEventEncoder(InetSocketAddress remoteAddress){
        this.remoteAddress = remoteAddress;
    }
    @Override
    protected void encode(ChannelHandlerContext ctx, EventLog eventLog, List<Object> list) throws Exception {
        byte[] file = eventLog.getLogfile().getBytes(CharsetUtil.UTF_8);
        byte[] msg = eventLog.getMsg().getBytes(CharsetUtil.UTF_8);
        ByteBuf buffer = ctx.alloc().buffer(file.length + msg.length + 1);
        buffer.writeBytes(file);
        buffer.writeByte(EventLog.SEPARATOR);
        buffer.writeBytes(msg);
        list.add(new DatagramPacket(buffer, remoteAddress));
    }
}
