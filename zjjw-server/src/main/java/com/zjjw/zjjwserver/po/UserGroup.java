package com.zjjw.zjjwserver.po;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@ToString
@Data
public class UserGroup {
    private Long id;

    private String name;

    private Long adminId;

    private String icon;

    private String notice;

    private String info;

    private String remark;

    private Date createTime;

    private Date updateTime;
}
