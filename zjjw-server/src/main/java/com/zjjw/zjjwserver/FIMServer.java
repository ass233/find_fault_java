package com.zjjw.zjjwserver;

import com.zjjw.zjjwserver.server.init.WebSocketChannelInitializer;
import com.zjjw.zjjwserver.util.SessionSocketHolder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.Map;

/**
 * Function:
 *
 * @author frozen
 *         Date: 21/05/2018 00:30
 * @since JDK 1.8
 */
@Component
public class FIMServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(FIMServer.class);

    private EventLoopGroup boss = new NioEventLoopGroup();
    private EventLoopGroup work = new NioEventLoopGroup();


    @Value("${zjjw.server.port}")
    private int nettyPort;


    /**
     * 启动 cim server
     *
     * @return
     * @throws InterruptedException
     */
    @PostConstruct
    public void start() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(boss, work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(nettyPort))
                //保持长连接
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new WebSocketChannelInitializer());
        ChannelFuture future = bootstrap.bind().sync();
        if (future.isSuccess()) {
            LOGGER.info("启动 fim server 成功");
        }
    }


    /**
     * 销毁
     */
    @PreDestroy
    public void destroy() {
        boss.shutdownGracefully().syncUninterruptibly();
        work.shutdownGracefully().syncUninterruptibly();
        LOGGER.info("关闭 cim server 成功");
    }


    /**
     * 私聊
     * @param userId
     * @param msg
     */
    public void sendP2pMsg(long userId,String msg){
        NioSocketChannel socketChannel = SessionSocketHolder.get(userId);
        if (null == socketChannel) {
            throw new NullPointerException("客户端[" + userId + "]不在线！");
        }
        ChannelFuture future = socketChannel.writeAndFlush(new TextWebSocketFrame(msg));
        future.addListener((ChannelFutureListener) channelFuture ->
                  LOGGER.info("服务端手动私聊发送消息成功={}", msg));
    }

    /**
     * 群聊
     * @param msg
     */
    public void sendAllMsg(String msg){
        Map<String, NioSocketChannel> map =  SessionSocketHolder.getUserMAP();
        for(Map.Entry<String, NioSocketChannel> entry:map.entrySet()){
            NioSocketChannel nioSocketChannel = entry.getValue();
            ChannelFuture future = nioSocketChannel.writeAndFlush(new TextWebSocketFrame(msg));
            future.addListener((ChannelFutureListener) channelFuture ->
                    LOGGER.info("服务端手动群聊给发送消息：{}，成功！",msg));
        }
    }
}
