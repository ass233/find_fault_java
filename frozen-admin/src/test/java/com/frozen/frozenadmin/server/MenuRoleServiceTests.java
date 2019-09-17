package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.MenuMapper;
import com.frozen.frozenadmin.dao.MenuRoleMapper;
import com.frozen.frozenadmin.po.MenuRole;
import com.frozen.frozenadmin.po.Role;
import com.frozen.frozenadmin.po.UserRole;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuRoleServiceTests {

    @Autowired
    MenuRoleMapper menuRoleMapper;
    MenuRole menuRole;
    public void initMenuRole(){
        if(menuRole==null) {
            synchronized (RoleServiceTests.class) {
                if(menuRole==null) {
                    menuRole = new MenuRole();
                    menuRole.setId(100l);
                    menuRole.setMenuId(100l);
                    menuRole.setReloId(100l);
                    menuRole.setCreateTime(new Date());
                    menuRole.setUpdateTime(new Date());
                }
            }
        }
    }
    @Test
    public void test() {
        RoleServiceTests roleServiceTests = new RoleServiceTests();
        MenuServiceTests menuServiceTests = new MenuServiceTests();
        try {
            roleServiceTests.initRole();
            menuServiceTests.initMenu();
            initMenuRole();
            insert();
            getByMenuId();
            getByRoleId();
            delete();
            roleServiceTests.delete();
            menuServiceTests.delete();
        }catch (Exception e){
            delete();
            roleServiceTests.delete();
            menuServiceTests.delete();
        }
    }
    @Test
    public void insert(){
        menuRoleMapper.insert(menuRole);
    }
    @Test
    public void delete(){
        menuRoleMapper.delete(menuRole.getId());
    }
    @Test
    public void getByMenuId(){
        menuRoleMapper.getByMenuId(menuRole.getMenuId());
    }
    @Test
    public void getByRoleId(){
        menuRoleMapper.getByRoleId(menuRole.getReloId());
    }

}
