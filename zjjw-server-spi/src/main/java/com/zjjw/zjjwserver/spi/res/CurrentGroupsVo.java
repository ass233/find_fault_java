package com.zjjw.zjjwserver.spi.res;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: Frozen
 * @create: 2019-10-25 14:36
 * @description:
 **/
@ToString
@Data
public class CurrentGroupsVo {
	private Integer unread;
	private String name;
	private long uid;
	List<VueUserVo> users;
}
