package com.sample.server;

import com.sample.initializer.ChatServerInitializer;
import com.sample.initializer.SecureChatServerInitializer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import java.net.InetSocketAddress;

/**
 * @Author: LJJ
 * @Program: netty-chat
 * @Description:
 * @Create: 2020-05-06 18:36:36
 * @Modified By:
 */
public class SecureChatServer extends ChatServer {
    private final SslContext sslContext;
    public SecureChatServer(SslContext sslContext){
        this.sslContext = sslContext;
    }

    @Override
    protected ChannelInitializer<Channel> createInitializer(ChannelGroup group){
        return new SecureChatServerInitializer(sslContext, group);
    }

    public static void main(String[] args) throws Exception{
        int port = 8080;
        SelfSignedCertificate certificate = new SelfSignedCertificate();
        SslContext context = SslContext.newServerContext(certificate.certificate(), certificate.privateKey());

        final SecureChatServer secureChatServer = new SecureChatServer(context);
        ChannelFuture future = secureChatServer.start(new InetSocketAddress(port));
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                secureChatServer.destroy();
            }
        });
        future.channel().closeFuture().syncUninterruptibly();
    }
}
