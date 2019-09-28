package com.zjjw.zjjwserver.services.im;

import com.zjjw.zjjwserver.server.command.InnerCommand;
import com.zjjw.zjjwserver.server.command.InnerCommandContext;
import com.zjjw.zjjwserver.util.SessionSocketHolder;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Auther: frozen
 * @Date: 2019/9/28 10:10
 * @Description:
 */
@Slf4j
public abstract class AbstractMsgHandler implements BaseMsgHandler{

    @Autowired
    private InnerCommandContext innerCommandContext ;

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
            log.warn("不能发送空消息！");
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

            log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } catch (Exception e) {
            log.error("Exception", e);
        }
    }

    private void printAllCommand(Map<String, String> allStatusCode) {
        log.warn("====================================");
        for (Map.Entry<String, String> stringStringEntry : allStatusCode.entrySet()) {
            String key = stringStringEntry.getKey();
            String value = stringStringEntry.getValue();
            log.warn(key + "----->" + value);
        }
        log.warn("====================================");
    }
}
