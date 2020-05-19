package com.sample.monitor;

import com.sample.decode.LogEventDecoder;
import com.sample.handler.EventLogHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

/**
 * @Author: LJJ
 * @Program: netty-udp
 * @Description:
 * @Create: 2020-05-06 22:31:31
 * @Modified By:
 */
public class LogEventMonitor {
    private final EventLoopGroup group;
    private final Bootstrap bootstrap;

    public LogEventMonitor(InetSocketAddress address){
        group = new NioEventLoopGroup();
        bootstrap = new io.netty.bootstrap.Bootstrap();
        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new LogEventDecoder());
                        pipeline.addLast(new EventLogHandler());
                    }
                })
                .localAddress(address);

    }

    public Channel bind(){
        return bootstrap.bind().syncUninterruptibly().channel();
    }

    public void stop(){
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception{
        int port = 8080;
        LogEventMonitor monitor = new LogEventMonitor(new InetSocketAddress(port));
        try{
            Channel channel = monitor.bind();
            System.out.println("LogEventMonitor is running....");
            channel.closeFuture().sync();
        }finally {
            monitor.stop();
        }
    }
}
