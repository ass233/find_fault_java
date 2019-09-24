package com.zjjw.zjjwserver.controller;

import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwserver.po.User;
import com.zjjw.zjjwserver.services.UserService;
import com.zjjw.zjjwserver.spi.res.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Frozen
 * @create: 2019-08-28 10:01
 * @description: 用户
 **/
@Controller
@RequestMapping("/")
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

    @RequestMapping(value = "getUserByUserName")
    @ResponseBody
    public BaseResponse getUserByUserName(@RequestBody UserVo userVo){
        BaseResponse response = BaseResponse.create(userVo);
        return response;
    }
}
