package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.MenuMapper;
import com.frozen.frozenadmin.dao.MenuRoleMapper;
import com.frozen.frozenadmin.dao.RoleMapper;
import com.frozen.frozenadmin.dao.UserRoleMapper;
import com.frozen.frozenadmin.po.Menu;
import com.frozen.frozenadmin.po.MenuRole;
import com.frozen.frozenadmin.po.Role;
import com.frozen.frozenadmin.po.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: frozen
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
}
