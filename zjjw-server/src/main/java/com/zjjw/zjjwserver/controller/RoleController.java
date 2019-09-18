package com.zjjw.zjjwserver.controller;

import com.zjjw.zjjwserver.po.Role;
import com.zjjw.zjjwserver.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Frozen
 * @create: 2019-08-28 10:01
 * @description:
 **/
@Controller
@RequestMapping("/")
@Slf4j
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping(value = "getAllRole")
    @ResponseBody
    public String getAllRole(){
        List<Role> list = roleService.getAllRole();
        log.info("allRole={}", Arrays.toString(list.toArray()));
        return Arrays.toString(list.toArray());
    }
}
