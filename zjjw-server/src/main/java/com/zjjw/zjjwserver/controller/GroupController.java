package com.zjjw.zjjwserver.controller;

import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwserver.po.GroupToUser;
import com.zjjw.zjjwserver.po.User;
import com.zjjw.zjjwserver.po.UserGroup;
import com.zjjw.zjjwserver.services.GroupService;
import com.zjjw.zjjwserver.services.GroupToUserService;
import com.zjjw.zjjwserver.services.UserService;
import com.zjjw.zjjwserver.spi.res.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Frozen
 * @create: 2019-08-28 10:01
 * @description: 用户
 **/
@Controller
@RequestMapping("/group")
@Slf4j
public class GroupController {
    @Autowired
    GroupService groupService;
    @Autowired
    GroupToUserService groupToUserService;

    @RequestMapping(value = "/createGroup")
    @ResponseBody
    public BaseResponse createGroup(@RequestBody UserGroupVo userGroupVo){
        log.info("userGroupVo={}",userGroupVo);
        UserGroup userGroup = new UserGroup();
        BeanUtils.copyProperties(userGroupVo,userGroup);
        long groupId = groupService.insert(userGroup);
        if(groupId<=0){
            return BaseResponse.createFail("创建群失败");
        }
        GroupToUser groupToUser = new GroupToUser();
        groupToUser.setGroupId(groupId);
        groupToUser.setUserId(userGroupVo.getAdminId());
        groupToUser.setNick(userGroupVo.getNick());
        int result =  groupToUserService.insert(groupToUser);
        if(result>0){
            return BaseResponse.createSuccess();
        }else {
            return BaseResponse.createFail("创建群失败");
        }
    }

    @RequestMapping(value = "/joinGroup")
    @ResponseBody
    public BaseResponse joinGroup(@RequestBody GroupToUserVo groupToUserVo){
        log.info("groupToUserVo={}",groupToUserVo);
        GroupToUser groupToUser = new GroupToUser();
        BeanUtils.copyProperties(groupToUserVo,groupToUser);
        int result =  groupToUserService.insert(groupToUser);
        if(result>0){
            return BaseResponse.createSuccess();
        }else {
            log.error("groupToUserVo={}",groupToUserVo);
            return BaseResponse.createFail("加入群失败");
        }
    }
	@RequestMapping(value = "/exitGroup")
	@ResponseBody
	public BaseResponse exitGroup(@RequestBody UserGroupVo userGroupVo){
		log.info("userGroupVo={}",userGroupVo);
		UserGroup userGroup = new UserGroup();
		BeanUtils.copyProperties(userGroupVo,userGroup);
		long groupId = groupService.insert(userGroup);
		if(groupId<=0){
			return BaseResponse.createFail("创建群失败");
		}
		GroupToUser groupToUser = new GroupToUser();
		groupToUser.setGroupId(groupId);
		groupToUser.setUserId(userGroupVo.getAdminId());
		groupToUser.setNick(userGroupVo.getNick());
		int result =  groupToUserService.insert(groupToUser);
		if(result>0){
			return BaseResponse.createSuccess();
		}else {
			return BaseResponse.createFail("创建群失败");
		}
	}

	@RequestMapping(value = "/getGroupByUser")
	@ResponseBody
	public BaseResponse getGroupByUser(@RequestBody UserVo userVo){
		log.info("UserVo={}",userVo);
		CurrentGroupsVo currentGroupsVo = new CurrentGroupsVo();
		currentGroupsVo.setName("分享群1");
		currentGroupsVo.setUid(1);
		currentGroupsVo.setUnread(1);
		List<VueUserVo> userVos = new ArrayList<>();
		VueUserVo vueUserVo = new VueUserVo();
		vueUserVo.setUid(1L);
		userVos.add(vueUserVo);
		currentGroupsVo.setUsers(userVos);
		List<CurrentGroupsVo> list = new ArrayList<>();
		list.add(currentGroupsVo);
		return BaseResponse.createSuccess(list);
	}
}
