package com.zjjw.zjjwserver.controller;

import com.zjjw.zjjwserver.services.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@Controller
@RequestMapping("/")
@Slf4j
public class IndexController {
    @Autowired
    MenuService menuService;

    @RequestMapping(value = "sendMsg")
    @ResponseBody
    public String sendMsg(@RequestParam String msg){
        log.info("allMenu={}", Arrays.toString(menuService.getAllMenu().toArray()));
        return "success";
    }

    @RequestMapping(value = "index")
    public String index(){
        return "/index";
    }
}
