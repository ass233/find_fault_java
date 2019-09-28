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
public  class HttpMsgHandler extends AbstractMsgHandler{
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpMsgHandler.class);
    @Autowired
    private InnerCommandContext innerCommandContext ;

    @Override
    public String sendMsg(String userId, String receiverId, String msg) {
        String sessionId = "";
        //群发
        if(StringUtils.isEmpty(sessionId)){
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
        return null;
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


    public boolean checkMsg(String msg) {
        if (StringUtils.isEmpty(msg)) {
            LOGGER.warn("不能发送空消息！");
            return true;
        }
        return false;
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
