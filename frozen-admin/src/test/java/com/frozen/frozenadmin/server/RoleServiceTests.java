package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.RoleMapper;
import com.frozen.frozenadmin.po.Role;
import com.frozen.frozenadmin.po.User;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTests {
    @Autowired
    RoleMapper roleMapper;
    Role role;
    public void initRole(){
        if(role==null) {
            synchronized (RoleServiceTests.class) {
                if(role==null) {
                    role = new Role();
                    role.setId(100l);
                    role.setName("frozenrole");
                    role.setNameZh("frozen管理员");
                    role.setCreateTime(new Date());
                    role.setUpdateTime(new Date());
                }
            }
        }
    }
    @Test
    public void test(){
        RoleServiceTests roleServiceTests = new RoleServiceTests();
        UserServiceTests userServiceTests = new UserServiceTests();
        roleServiceTests.initRole();
        userServiceTests.initUser();
        initRole();
        insert();
        update();
        getById();
        getByName();
        list();
        listAll();
        listByIds();
        delete();
    }
    @Test
    public void insert(){
        roleMapper.insert(role);
    }
    @Test
    public void delete(){
        roleMapper.delete(role.getId());
    }
    @Test
    public void update(){
        roleMapper.update(role);
    }
    @Test
    public void getById(){
        roleMapper.getById(role.getId());
    }
    @Test
    public void getByName(){
        roleMapper.getByName(role.getName());
    }
    @Test
    public void list(){
        roleMapper.list(role);
    }
    @Test
    public void listAll(){
        roleMapper.listAll(role);
    }
    @Test
    public void listByIds(){
        List<Long> ids = new ArrayList<>();
        ids.add(role.getId());
        roleMapper.listByIds(ids);
    }
}
