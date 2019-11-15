package com.zjjw.zjjwserver.spi.res;

import lombok.Data;
import lombok.ToString;

/**
 * @author: Frozen
 * @create: 2019-10-25 15:41
 * @description:
 **/
@ToString
@Data
public class CurrentUserVo {
	private Integer unread;
	private String nickname;
	private Long id;
}
