package com.zjjw.zjjwserver.services;

import com.zjjw.zjjwserver.dao.UserGroupMapper;
import com.zjjw.zjjwserver.po.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: zjjw
 * @Date: 2019/4/21 08:27
 * @Description:
 */
@Service
public class GroupService {

    @Autowired
    UserGroupMapper groupMapper;

	public long insert(UserGroup userGroup) {
		userGroup.setCreateTime(new Date());
		userGroup.setUpdateTime(new Date());
		groupMapper.insert(userGroup);
		return userGroup.getId();
	}

}
