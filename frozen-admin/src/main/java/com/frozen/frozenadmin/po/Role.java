package com.frozen.frozenadmin.po;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

@ToString
@Data
public class Role {
    private Long id;

    private String name;

    private String nameZh;

    private Date createTime;

    private Date updateTime;

}