package com.sample.bootstrap;

import com.sample.domain.EventLog;
import com.sample.encode.LogEventEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

/**
 * @Author: LJJ
 * @Program: netty-udp
 * @Description:
 * @Create: 2020-05-06 21:57:57
 * @Modified By:
 */
public class LogEventBroadcaster {
    private final EventLoopGroup group;
    private final Bootstrap bootstrap;
    private final File file;

    public LogEventBroadcaster(InetSocketAddress remoteAddress, File file){
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        this.file = file;
        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new LogEventEncoder(remoteAddress));
    }

    public void run() throws Exception {
        Channel ch = bootstrap.bind(0).sync().channel();
        long pointer = 0;
        for (;;){
            long len = file.length();
            if (len < pointer){
                pointer = len;
            }else if (len > pointer){
                RandomAccessFile raf = new RandomAccessFile(this.file, "r");
                raf.seek(pointer);
                String line;
                while ((line = raf.readLine()) != null){
                    ch.writeAndFlush(new EventLog(null, -1, file.getAbsolutePath(), line));
                }
                pointer = raf.getFilePointer();
                raf.close();
            }
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        String path = "G:/some.txt";
        LogEventBroadcaster broadcaster = new LogEventBroadcaster(
                new InetSocketAddress("255.255.255.255", port), new File(path));
        try{
            broadcaster.run();
        } finally {
            broadcaster.stop();
        }
    }
}
