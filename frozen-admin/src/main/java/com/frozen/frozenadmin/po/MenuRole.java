package com.frozen.frozenadmin.po;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

@ToString
@Data
public class MenuRole {
    private Long id;

    private Long menuId;

    private Long reloId;

    private Date createTime;

    private Date updateTime;

}