package com.zjjw.zjjwserver.server;

import com.zjjw.zjjwserver.server.command.InnerCommand;
import com.zjjw.zjjwserver.server.command.InnerCommandContext;
import com.zjjw.zjjwserver.util.SessionSocketHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
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
public class MsgHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(MsgHandler.class);
    @Autowired
    private InnerCommandContext innerCommandContext ;

    public String sendMsg(String sessionId, String msg) {
        String[] totalMsg = msg.split(";;");
        if (totalMsg.length > 1) {
            //私聊
            LOGGER.info("私聊");
            NioSocketChannel nioSocketChannel = SessionSocketHolder.getMAP().get(totalMsg[1]);
            if(nioSocketChannel==null){
                return "用户不在线";
            }
            nioSocketChannel.writeAndFlush(new TextWebSocketFrame(msg));
        } else {
            //群聊
            LOGGER.info("群聊");
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
        return "返回应答";
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



    /**
     * 查询聊天记录
     *
     * @param msg
     */
    private void queryChatHistory(String msg) {
        String[] split = msg.split(" ");

        System.out.println();
    }

    /**
     * 打印在线用户
     */
    private void printOnlineUsers() {
        try {

            LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } catch (Exception e) {
            LOGGER.error("Exception", e);
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
