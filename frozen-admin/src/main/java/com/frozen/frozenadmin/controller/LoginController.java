package com.frozen.frozenadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {
    @RequestMapping(value = "login")
    @ResponseBody
    public String index(){
        return "123456";
    }
}
