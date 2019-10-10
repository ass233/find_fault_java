package com.zjjw.zjjwserver.services.im;

import com.zjjw.zjjwserver.cache.UserSessionCache;
import com.zjjw.zjjwserver.server.command.InnerCommand;
import com.zjjw.zjjwserver.server.command.InnerCommandContext;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Function:
 *
 * @author frozen
 * Date: 2018/12/26 11:15
 * @since JDK 1.8
 */
@Service
@Slf4j
public  class HttpMsgGroupHandler extends AbstractMsgHandler{
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpMsgGroupHandler.class);
    @Autowired
    private InnerCommandContext innerCommandContext ;

    @Override
    public String sendMsg(String userId, String receiverId, String msg) {
        try {
            NioSocketChannel socketChannel = UserSessionCache.get(receiverId);
            if (null == socketChannel) {
                log.error("receiverId={}不在线",receiverId);
                return receiverId+"不在线";
            }
            socketChannel.writeAndFlush(new TextWebSocketFrame(msg));
            ChannelFuture future = socketChannel.writeAndFlush(msg);
            future.addListener((ChannelFutureListener) channelFuture ->
                    LOGGER.info("服务端手动发送成功={}", msg));
            return null;
        }catch (Exception e){
            return "发送消息失败";
        }
    }

}
