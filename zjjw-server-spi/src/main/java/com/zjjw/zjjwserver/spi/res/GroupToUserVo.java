package com.zjjw.zjjwserver.spi.res;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class GroupToUserVo {

    private Long userId;

    private Long groupId;

    private String nick;

}
