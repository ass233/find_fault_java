package com.zjjw.zjjwserver.im;

import com.zjjw.zjjwserver.po.UserGroup;
import com.zjjw.zjjwserver.services.GroupService;
import com.zjjw.zjjwserver.services.im.HttpMsgGroupHandler;
import com.zjjw.zjjwserver.services.im.HttpMsgHandler;
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
public class HttpGroupSendTest {
	@Autowired
	HttpMsgGroupHandler httpMsgGroupHandler;
	@Test
	public void addGroup(){
		log.info("sendMsg "+httpMsgGroupHandler.sendMsg("1","2","hhh"));
	}
}
