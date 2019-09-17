package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.UserRoleMapper;
import com.frozen.frozenadmin.po.Menu;
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
public class UserRoleServiceTests {
    @Autowired
    UserRoleMapper userRoleMapper;
    private UserRole userRole;
    public void initUserRole(){
        if(userRole==null) {
            synchronized (MenuServiceTests.class) {
                if(userRole==null) {
                    userRole = new UserRole();
                    userRole.setId(100l);
                    userRole.setUserId(100l);
                    userRole.setReloId(100l);
                    userRole.setCreateTime(new Date());
                    userRole.setUpdateTime(new Date());
                }
            }
        }
    }
    @Test
    public void test() {
        RoleServiceTests roleServiceTests = new RoleServiceTests();
        UserServiceTests userServiceTests = new UserServiceTests();
        try {
            roleServiceTests.initRole();
            userServiceTests.initUser();
            initUserRole();
            insert();
            getByRoleId();
            delete();
            roleServiceTests.delete();
            userServiceTests.delete();
        }catch (Exception e){
            delete();
            roleServiceTests.delete();
            userServiceTests.delete();
        }
    }
    public void insert(){
        userRoleMapper.insert(userRole);
    }

    public void delete(){
        userRoleMapper.delete(userRole.getId());
    }

    public void getByUserId(){
        userRoleMapper.getByUserId(userRole.getUserId());
    }

    public void getByRoleId(){
        userRoleMapper.getByRoleId(userRole.getReloId());
    }

}
