package com.sample.decode;

import com.sample.domain.EventLog;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: netty-udp
 * @Description:
 * @Create: 2020-05-06 22:20:20
 * @Modified By:
 */
public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket datagramPacket, List<Object> out) throws Exception {
        ByteBuf data = datagramPacket.content();
        int index = data.indexOf(0, data.readableBytes(), EventLog.SEPARATOR);
        String filename = data.slice(0, index).toString(CharsetUtil.UTF_8);
        String msg = data.slice(index+1, data.readableBytes()).toString(CharsetUtil.UTF_8);

        EventLog eventLog = new EventLog(datagramPacket.sender(), System.currentTimeMillis(), filename, msg);
        out.add(eventLog);
    }
}
