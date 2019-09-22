package com.zjjw.zjjwserver.spi.res;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class UserRoleVo {
    private Long id;

    private Long userId;

    private Long reloId;

    private Date createTime;

    private Date updateTime;
}
