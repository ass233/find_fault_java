package com.zjjw.zjjwserver.controller;

import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwserver.po.Role;
import com.zjjw.zjjwserver.po.UserRole;
import com.zjjw.zjjwserver.services.RoleService;
import com.zjjw.zjjwserver.spi.res.MenuVo;
import com.zjjw.zjjwserver.spi.res.RoleVo;
import com.zjjw.zjjwserver.spi.res.UserRoleVo;
import com.zjjw.zjjwserver.spi.res.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @RequestMapping(value = "getListByUserId")
    @ResponseBody
    public BaseResponse getListByUserId(@RequestBody UserRoleVo userRoleVo){
        List<RoleVo> list =new ArrayList<>();
        List<Role> roles =roleService.getRolesByUserId(userRoleVo.getUserId());
        if(!CollectionUtils.isEmpty(roles)){
            for(Role role :roles){
                RoleVo roleVo = new RoleVo();
                BeanUtils.copyProperties(role,roleVo);
                list.add(roleVo);
            }
        }
        BaseResponse response = BaseResponse.create(list);
        return response;
    }

    @RequestMapping(value = "getListByMenuUrl")
    @ResponseBody
    public BaseResponse getListByMenuUrl(@RequestBody MenuVo menuVo){
        List<RoleVo> list = new ArrayList<>();
        RoleVo roleVo = new RoleVo();
        roleVo.setId(1l);
        list.add(roleVo);
        BaseResponse response = BaseResponse.create(list);
        return response;
    }
}
