package com.zjjw.zjjwserver.server.handle;

import com.zjjw.zjjwserver.services.im.MsgHandler;
import com.zjjw.zjjwserver.cache.SessionSocketCache;
import com.zjjw.zjjwserver.util.SpringBeanFactory;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Frozen
 * @create: frozen-07 09:45
 * @description:
 **/
public class WebSocketHandle extends SimpleChannelInboundHandler<Object> {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketHandle.class);
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String sessionId = ctx.channel().id().asLongText();
        LOGGER.info("channelActive connect sessionId={}",sessionId);
        SessionSocketCache.put(sessionId,(NioSocketChannel) ctx.channel());
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //判断是否ws消息
        if(msg instanceof TextWebSocketFrame){
            String msgStr= ((TextWebSocketFrame)msg).text();
            MsgHandler msgHandler = SpringBeanFactory.getBean(MsgHandler.class) ;
            //获取发送人sessionId
            String sessionId = ctx.channel().id().asLongText();
            //ws登录
            if (msgHandler.login(ctx, sessionId, msgStr)) {
                return;
            }
            //发送消息
            String respones = msgHandler.sendMsg(sessionId,null,msgStr);
            //返回发送结果
            //ctx.channel().writeAndFlush(new TextWebSocketFrame(respones));
        }else if(msg instanceof BinaryWebSocketFrame){
            LOGGER.info("收到二进制消息："+((BinaryWebSocketFrame)msg).content().readableBytes());
            BinaryWebSocketFrame binaryWebSocketFrame=new BinaryWebSocketFrame(Unpooled.buffer().writeBytes("xxx".getBytes()));
            ctx.channel().writeAndFlush(binaryWebSocketFrame);
        }
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("channelUnregistered");
        String sessionId = ctx.channel().id().asLongText();
        SessionSocketCache.removeUser(sessionId);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("channelInactive");
    }
}
