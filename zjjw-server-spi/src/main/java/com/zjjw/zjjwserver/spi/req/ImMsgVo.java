package com.zjjw.zjjwserver.spi.req;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class ImMsgVo {
    private Long userId;

    private Long receiverId;

    private String msg;
}
