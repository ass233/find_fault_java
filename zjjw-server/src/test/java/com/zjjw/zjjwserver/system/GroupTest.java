package com.zjjw.zjjwserver.system;

import com.zjjw.zjjwserver.po.UserGroup;
import com.zjjw.zjjwserver.services.GroupService;
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
public class GroupTest {
	@Autowired
	GroupService groupService;

	private UserGroup initE(){
		UserGroup userGroup = new UserGroup();
		userGroup.setName("某某实验班");
		userGroup.setAdminId(1l);
		userGroup.setIcon("icon");
		userGroup.setNotice("群公告，大家注意");
		userGroup.setInfo("某某实验班");
		userGroup.setRemark("备注");
		userGroup.setCreateTime(new Date());
		userGroup.setUpdateTime(new Date());
		return userGroup;
	}
	@Test
	public void addGroup(){
		log.info("addGroup "+groupService.insert(this.initE()));
	}
}
