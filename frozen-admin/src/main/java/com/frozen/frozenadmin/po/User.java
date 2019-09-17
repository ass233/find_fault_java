package com.frozen.frozenadmin.po;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

@ToString
@Data
public class User {
    private Long id;

    private String name;

    private String phone;

    private String telephone;

    private String address;

    private Boolean enabled;

    private String username;

    private String password;

    private String userface;

    private String remark;

    private Date createTime;

    private Date updateTime;

}