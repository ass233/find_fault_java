package com.zjjw.zjjwserver.services.im;

import com.zjjw.zjjwserver.server.command.InnerCommand;
import com.zjjw.zjjwserver.server.command.InnerCommandContext;
import com.zjjw.zjjwserver.util.SessionSocketHolder;
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
public  class MsgHandler extends AbstractMsgHandler{

    @Override
    public String sendMsg(String sessionId, String receiverId, String msg) {
        String[] totalMsg = msg.split(";;");
        if (totalMsg.length > 1) {
            //私聊
            log.info("私聊");
            NioSocketChannel nioSocketChannel = SessionSocketHolder.getMAP().get(totalMsg[1]);
            if(nioSocketChannel==null){
                return "用户不在线";
            }
            nioSocketChannel.writeAndFlush(new TextWebSocketFrame(msg));
        } else {
            //群聊
            log.info("群聊");
            Map<String, NioSocketChannel> map =  SessionSocketHolder.getUserMAP();
            for(Map.Entry<String, NioSocketChannel> entry:map.entrySet()){
                //过滤自己
                if(sessionId.equals(entry.getKey())){
                    continue;
                }
                NioSocketChannel nioSocketChannel = entry.getValue();
                nioSocketChannel.writeAndFlush(new TextWebSocketFrame(msg));
            }
        }
        return "消息发送成功";
    }
    /**
     * 处理用户消息通道
     * @param ctx
     * @param msg
     */
    public void channelHandler(ChannelHandlerContext ctx,String msg) {
        if(!StringUtils.isEmpty(msg)){
            if(msg.contains("login")){
                String[] strings = StringUtils.split(msg,":");
                SessionSocketHolder.put(Long.valueOf(strings[1]), (NioSocketChannel) ctx.channel());
            }
        }
    }

}
