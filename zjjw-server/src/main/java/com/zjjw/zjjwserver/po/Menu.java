package com.zjjw.zjjwserver.po;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class Menu {
    private Long id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private Boolean keepAlive;

    private Boolean requireAuth;

    private Long parentId;

    private Boolean enabled;

    private Date createTime;

    private Date updateTime;

}
