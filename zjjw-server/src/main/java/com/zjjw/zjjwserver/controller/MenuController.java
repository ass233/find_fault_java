package com.zjjw.zjjwserver.controller;

import com.zjjw.zjjwserver.po.Menu;
import com.zjjw.zjjwserver.services.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Frozen
 * @create: 2019-08-28 10:02
 * @description:
 **/
@Controller
@RequestMapping("/")
@Slf4j
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping(value = "getAllMenu")
    @ResponseBody
    public String getAllMenu(){
        List<Menu> list = menuService.getAllMenu();
        log.info("allMenu={}", Arrays.toString(list.toArray()));
        return Arrays.toString(list.toArray());
    }
}
