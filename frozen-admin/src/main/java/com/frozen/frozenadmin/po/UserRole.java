package com.frozen.frozenadmin.po;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

@ToString
@Data
public class UserRole {
    private Long id;

    private Long userId;

    private Long reloId;

    private Date createTime;

    private Date updateTime;
}