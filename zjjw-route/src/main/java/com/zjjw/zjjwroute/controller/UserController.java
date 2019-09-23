package com.zjjw.zjjwroute.controller;

import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.service.UserService;
import com.zjjw.zjjwroute.vo.req.LoginReqVO;
import com.zjjw.zjjwserver.spi.res.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@Controller
@RequestMapping("/")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "getUserByUserName", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getUserByUserName(@RequestBody UserVo userVo){
        userVo = userService.getPasswordByUserName(userVo.getName());
        return BaseResponse.create(userVo);
    }
}
