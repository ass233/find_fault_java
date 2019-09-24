package com.zjjw.zjjwserver.spi.res;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class RoleVo {
    private Long id;

    private String name;

    private String nameZh;

    private Date createTime;

    private Date updateTime;

}
