package com.zjjw.zjjwserver.services.im;

import com.zjjw.zjjwserver.cache.UserSessionCache;
import com.zjjw.zjjwserver.server.command.InnerCommand;
import com.zjjw.zjjwserver.server.command.InnerCommandContext;
import com.zjjw.zjjwserver.cache.SessionSocketCache;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public  class HttpMsgHandler extends AbstractMsgHandler{
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpMsgHandler.class);
    @Autowired
    InnerCommandContext innerCommandContext ;

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

    /**
     * AI model
     *
     * @param msg
     */
    private String aiChat(String msg) {
        msg = msg.replace("吗", "");
        msg = msg.replace("嘛", "");
        msg = msg.replace("?", "!");
        msg = msg.replace("？", "!");
        msg = msg.replace("你", "我");
        return msg;
    }


    /**
     * 内置命令
     * @param msg
     * @return
     */
    public boolean innerCommand(String msg) {
        if (msg.startsWith(":")) {
            InnerCommand instance = innerCommandContext.getInstance(msg);
            instance.process(msg) ;

            return true;

        } else {
            return false;
        }


    }


    private void printAllCommand(Map<String, String> allStatusCode) {
        LOGGER.warn("====================================");
        for (Map.Entry<String, String> stringStringEntry : allStatusCode.entrySet()) {
            String key = stringStringEntry.getKey();
            String value = stringStringEntry.getValue();
            LOGGER.warn(key + "----->" + value);
        }
        LOGGER.warn("====================================");
    }

}
