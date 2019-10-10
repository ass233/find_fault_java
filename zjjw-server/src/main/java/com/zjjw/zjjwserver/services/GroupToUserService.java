package com.zjjw.zjjwserver.services;

import com.zjjw.zjjwserver.dao.GroupToUserMapper;
import com.zjjw.zjjwserver.dao.UserGroupMapper;
import com.zjjw.zjjwserver.po.GroupToUser;
import com.zjjw.zjjwserver.po.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zjjw
 * @Date: 2019/4/21 08:27
 * @Description:
 */
@Service
public class GroupToUserService {

    @Autowired
    GroupToUserMapper groupToUserMapper;

	public int insert(GroupToUser groupToUser) {
		return groupToUserMapper.insert(groupToUser);
	}

	public List<GroupToUser> list(GroupToUser groupToUser){
		return groupToUserMapper.list(groupToUser);
	}
}
