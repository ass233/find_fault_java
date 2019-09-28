package com.zjjw.zjjwserver.services.im;

/**
 * @Auther: frozen
 * @Date: 2019/9/28 09:20
 * @Description:
 */
public interface BaseMsgHandler {
    String sendMsg(String senderId,String receiverId, String msg,Integer type);
}
