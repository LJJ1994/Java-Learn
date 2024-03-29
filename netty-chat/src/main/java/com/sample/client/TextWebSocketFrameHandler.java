package com.sample.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * @Author: LJJ
 * @Program: netty-chat
 * @Description:
 * @Create: 2020-05-06 16:47:47
 * @Modified By:
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private final ChannelGroup group;
    public TextWebSocketFrameHandler(ChannelGroup group){
        this.group = group;
    }

    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE){
            ctx.pipeline().remove(HttpRequestHandler.class);
            group.writeAndFlush(new TextWebSocketFrame(
                    "Client " + ctx.channel() + " joined;"
            ));
            group.add(ctx.channel());
        } else{
            super.userEventTriggered(ctx, evt);
        }
    }

    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        group.writeAndFlush(msg.retain());
    }
}
