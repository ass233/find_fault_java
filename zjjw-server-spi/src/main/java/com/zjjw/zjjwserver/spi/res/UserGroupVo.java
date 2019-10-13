package com.zjjw.zjjwserver.spi.res;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class UserGroupVo {
    private Long id;

    private String name;

    private Long adminId;

    private String icon;

    private String notice;

    private String info;

    private String remark;

    private String nick;

    private Date createTime;

    private Date updateTime;
}
