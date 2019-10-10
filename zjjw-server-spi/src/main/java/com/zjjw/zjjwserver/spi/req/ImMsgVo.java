package com.zjjw.zjjwserver.spi.req;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class ImMsgVo {
	//发送者ID
    private Long userId;
	//接受者ID
    private Long receiverId;
	//消息内容
    private String msg;
    //消息类型
    private Integer type;
}
