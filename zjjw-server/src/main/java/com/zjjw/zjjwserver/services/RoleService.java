package com.zjjw.zjjwserver.services;

import com.zjjw.zjjwserver.dao.MenuMapper;
import com.zjjw.zjjwserver.dao.MenuRoleMapper;
import com.zjjw.zjjwserver.dao.RoleMapper;
import com.zjjw.zjjwserver.dao.UserRoleMapper;
import com.zjjw.zjjwserver.po.Menu;
import com.zjjw.zjjwserver.po.MenuRole;
import com.zjjw.zjjwserver.po.Role;
import com.zjjw.zjjwserver.po.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: zjjw
 * @Date: 2019/4/21 08:27
 * @Description:
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;
    @Autowired
    MenuMapper menuMapper;
    /**
     * 根据用户ID查询用户角色列表
     * @param userId
     * @return
     */
    public List<Role> getRolesByUserId(Long userId){
        List<UserRole> userRoles = userRoleMapper.getByUserId(userId);
        if(CollectionUtils.isEmpty(userRoles)){
            return new ArrayList<>();
        }
        List<Long> ids = new ArrayList<>();
        for(UserRole userRole:userRoles){
            ids.add(userRole.getId());
        }
        return roleMapper.listByIds(ids);
    }
    /**
     * 根据菜单获取角色
     * @param menu
     * @return
     */
    public List<Role> getRolesByMenu(Menu menu){
        List<MenuRole> menuRoles = menuRoleMapper.getByMenuId(menu.getId());
        if(CollectionUtils.isEmpty(menuRoles)){
            return new ArrayList<>();
        }
        List<Long> ids = new ArrayList<>();
        for(MenuRole menuRole:menuRoles){
            ids.add(menuRole.getId());
        }
        return roleMapper.listByIds(ids);
    }

    /**
     * 获取所有的角色
     * @return
     */
    public List<Role> getAllRole(){
        return roleMapper.getAllRole();
    }
}
