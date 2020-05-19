package com.sample.domain;

import java.net.InetSocketAddress;

/**
 * @Author: LJJ
 * @Program: netty-udp
 * @Description:
 * @Create: 2020-05-06 21:33:33
 * @Modified By:
 */
public class EventLog {
    public static final byte SEPARATOR = (byte) ':';
    public final InetSocketAddress source;
    private final String logfile;
    private final String msg;
    private final long received;

    public EventLog(InetSocketAddress source, long received, String logfile, String msg){
        this.source = source;
        this.received = received;
        this.logfile = logfile;
        this.msg = msg;
    }

    public EventLog(String logfile, String msg){
        this(null, -1, logfile, msg);
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogfile() {
        return logfile;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceived() {
        return received;
    }
}
