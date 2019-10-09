package com.zjjw.zjjwserver.system;

import com.zjjw.zjjwserver.po.GroupToUser;
import com.zjjw.zjjwserver.po.UserGroup;
import com.zjjw.zjjwserver.services.GroupService;
import com.zjjw.zjjwserver.services.GroupToUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author: Frozen
 * @create: 2019-10-09 18:33
 * @description: 用户测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GroupToUserTest {
	@Autowired
	GroupToUserService groupToUserService;

	private GroupToUser initE(){
		GroupToUser userGroup = new GroupToUser();
		userGroup.setCreateTime(new Date());
		userGroup.setUpdateTime(new Date());
		return userGroup;
	}
	@Test
	public void addGroupToUser(){
		log.info("addGroupToUser "+groupToUserService.insert(this.initE()));
	}
}
