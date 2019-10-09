package com.zjjw.zjjwserver.system;

import com.zjjw.zjjwserver.po.User;
import com.zjjw.zjjwserver.services.UserService;
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
public class UserTest {
	@Autowired
	UserService userService;

	private User initE(){
		User user = new User();
		user.setName("yezi");
		user.setPhone("13000000561");
		user.setTelephone("13000000561");
		user.setAddress("北京朝阳");
		user.setEnabled(true);
		user.setUsername("yezi");
		user.setPassword("123456");
		user.setSalt("123456");
		user.setUserface("450326199502082336");
		user.setRemark("高级用户");
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		return user;
	}
	@Test
	public void addUsers(){
		log.info("addUsers "+userService.insert(this.initE()));
	}
}
