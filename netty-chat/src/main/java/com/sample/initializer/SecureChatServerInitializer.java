package com.sample.initializer;

import com.sample.client.HttpRequestHandler;
import com.sample.client.TextWebSocketFrameHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import javax.net.ssl.SSLEngine;

/**
 * @Author: LJJ
 * @Program: netty-chat
 * @Description:
 * @Create: 2020-05-06 18:32:32
 * @Modified By:
 */
public class SecureChatServerInitializer extends ChatServerInitializer {
    private final SslContext context;
    public SecureChatServerInitializer(SslContext context, ChannelGroup group) {
        super(group);
        this.context = context;
    }

    protected void initChannel(Channel channel) throws Exception {
        super.initChannel(channel);
        ChannelPipeline pipeline = channel.pipeline();
        SSLEngine sslEngine = context.newEngine(channel.alloc());
        sslEngine.setUseClientMode(false);
        pipeline.addFirst(new SslHandler(sslEngine));
    }
}
