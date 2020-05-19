package com.sample.handler;

import com.sample.domain.EventLog;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: LJJ
 * @Program: netty-udp
 * @Description:
 * @Create: 2020-05-06 22:25:25
 * @Modified By:
 */
public class EventLogHandler extends SimpleChannelInboundHandler<EventLog> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, EventLog eventLog) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(eventLog.getReceived());
        sb.append("[");
        sb.append(eventLog.getSource().toString());
        sb.append("] [");
        sb.append(eventLog.getLogfile());
        sb.append("] :");
        sb.append(eventLog.getMsg());

        System.out.println(sb.toString());
    }
}
