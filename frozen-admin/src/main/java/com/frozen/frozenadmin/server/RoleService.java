package com.frozen.frozenadmin.server;

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
    /**
     * 根据用户ID查询用户角色列表
     * @param userId
     * @return
     */
    public List<Role> getRolesByUserId(Long userId){
        List<Role> roles =   new ArrayList<>();
        Role role = new Role();
        role.setName("admin");
        roles.add(role);
        return roles;
    }
    /**
     * 根据菜单获取角色
     * @param menu
     * @return
     */
    public List<Role> getRolesByMenu(Menu menu){
        return new ArrayList<>();
    }
}
