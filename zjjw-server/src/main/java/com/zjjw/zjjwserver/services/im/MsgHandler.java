package com.zjjw.zjjwserver.services.im;

import com.zjjw.zjjwserver.cache.SessionSocketCache;
import com.zjjw.zjjwserver.cache.UserSessionCache;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
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
public class MsgHandler extends AbstractMsgHandler {

    @Override
    public String sendMsg(String sessionId, String receiverId, String msg) {
        String[] totalMsg = msg.split(";;");
        if (totalMsg.length > 1) {
            //私聊
            log.info("私聊");
            NioSocketChannel nioSocketChannel = SessionSocketCache.getUserMAP().get(totalMsg[1]);
            if (nioSocketChannel == null) {
                return "用户不在线";
            }
            nioSocketChannel.writeAndFlush(new TextWebSocketFrame(msg));
        } else {
            //群聊
            log.info("群聊");
            Map<String, NioSocketChannel> map = SessionSocketCache.getUserMAP();
            for (Map.Entry<String, NioSocketChannel> entry : map.entrySet()) {
                //过滤自己
                if (sessionId.equals(entry.getKey())) {
                    continue;
                }
                NioSocketChannel nioSocketChannel = entry.getValue();
                nioSocketChannel.writeAndFlush(new TextWebSocketFrame(msg));
            }
        }
        return "消息发送成功";
    }

    /**
     * 用户登录连接
     *
     * @param ctx
     * @param msg
     */
    public boolean login(ChannelHandlerContext ctx, String sessionId, String msg) {
        if (StringUtils.isEmpty(msg)) {
            return false;
        }
        if (!msg.contains("login")) {
            return false;
        }
        SessionSocketCache.put(sessionId, (NioSocketChannel) ctx.channel());
        String[] strings = StringUtils.split(msg, ":");
        if (strings.length<2) {
            return false;
        }
        String userId =strings[1];
        UserSessionCache.put(userId,(NioSocketChannel) ctx.channel());
        return true;
    }

}
