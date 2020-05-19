package com.sample.encodedecode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.websocketx.*;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: plain-nio-sample
 * @Description:
 * @Create: 2020-05-06 00:35:35
 * @Modified By:
 */
public class WebSocketConvertHandler extends MessageToMessageCodec<WebSocketFrame, WebSocketConvertHandler.MyWebSocketFrame> {
    protected void encode(ChannelHandlerContext ctx, MyWebSocketFrame msg, List<Object> list) throws Exception {
        ByteBuf payload = msg.getData().duplicate().retain();
        switch (msg.getType()){
            case BINARY:
                list.add(new BinaryWebSocketFrame(payload));
                break;
            case PING:
                list.add(new PingWebSocketFrame(payload));
                break;
            case PONG:
                list.add(new PongWebSocketFrame(payload));
                break;
            case TEXT:
                list.add(new TextWebSocketFrame(payload));
                break;
            case CONTINUATION:
                list.add(new ContinuationWebSocketFrame(payload));
                break;
            case CLOSE:
                list.add(new CloseWebSocketFrame());
                break;
            default:
                throw new IllegalStateException("Unsupported websocket msg: " + msg);
        }
    }

    protected void decode(ChannelHandlerContext ctx, WebSocketFrame msg, List<Object> list) throws Exception {
        ByteBuf payload = msg.content().duplicate().retain();
        if (msg instanceof BinaryWebSocketFrame){
            list.add(new MyWebSocketFrame(payload, MyWebSocketFrame.FrameType.BINARY));
        } else if (msg instanceof CloseWebSocketFrame){
            list.add(new MyWebSocketFrame(payload, MyWebSocketFrame.FrameType.CLOSE));
        } else if (msg instanceof PingWebSocketFrame){
            list.add(new MyWebSocketFrame(payload, MyWebSocketFrame.FrameType.PING));
        } else if (msg instanceof PongWebSocketFrame){
            list.add(new MyWebSocketFrame(payload, MyWebSocketFrame.FrameType.PONG));
        } else if (msg instanceof TextWebSocketFrame){
            list.add(new MyWebSocketFrame(payload, MyWebSocketFrame.FrameType.TEXT));
        } else if (msg instanceof ContinuationWebSocketFrame){
            list.add(new MyWebSocketFrame(payload, MyWebSocketFrame.FrameType.CONTINUATION));
        }else{
            throw new IllegalStateException("Unsupported websocket msg: " + msg);
        }
    }

    public static class MyWebSocketFrame{
        public enum FrameType{
            BINARY,
            CLOSE,
            PING,
            PONG,
            TEXT,
            CONTINUATION
        }
        private final ByteBuf data;
        private final FrameType type;
        public MyWebSocketFrame(ByteBuf data, FrameType type){
            this.data = data;
            this.type = type;
        }
        public ByteBuf getData(){
            return data;
        }
        public FrameType getType(){
            return type;
        }
    }
}
