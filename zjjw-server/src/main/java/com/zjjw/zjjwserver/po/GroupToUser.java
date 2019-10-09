package com.zjjw.zjjwserver.po;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@ToString
@Data
public class GroupToUser {
    private Long id;

    private Long userId;

    private Long groupId;

    private String nick;

    private Date createTime;

    private Date updateTime;

}
