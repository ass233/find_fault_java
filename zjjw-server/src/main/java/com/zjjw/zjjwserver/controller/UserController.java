package com.zjjw.zjjwserver.controller;

import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwserver.po.User;
import com.zjjw.zjjwserver.services.UserService;
import com.zjjw.zjjwserver.spi.res.CurrentUserVo;
import com.zjjw.zjjwserver.spi.res.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "getAllUser")
    @ResponseBody
    public String getAllUser(){
        List<User> list = userService.getAllUser();
        log.info("allUser={}", Arrays.toString(list.toArray()));
        return Arrays.toString(list.toArray());
    }

    @RequestMapping(value = "getByName")
    @ResponseBody
    public BaseResponse getByName(@RequestBody UserVo userVo){
        User user = userService.getByName(userVo.getName());
        UserVo userVo1 = new UserVo();
        BeanUtils.copyProperties(user,userVo1);
        BaseResponse response = BaseResponse.createSuccess(userVo1);
        return response;
    }

	@RequestMapping(value = "getRelations")
	@ResponseBody
	public BaseResponse getRelations(@RequestBody UserVo userVo){
		log.info("userVo={}",userVo);
		List<CurrentUserVo> userVoList = new ArrayList<>();
		CurrentUserVo currentUserVo = new CurrentUserVo();
		currentUserVo.setId(02L);
		currentUserVo.setNickname("fenfen");
		currentUserVo.setUnread(2);
		userVoList.add(currentUserVo);
		return BaseResponse.createSuccess(userVoList);
	}
}
