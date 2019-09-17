package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.UserMapper;
import com.frozen.frozenadmin.po.User;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserServiceTests {
    @Autowired
    UserMapper userMapper;

    private User user;

    public void initUser(){
        if(user==null) {
            synchronized (UserServiceTests.class) {
                if(user==null) {
                    user = new User();
                    user.setId(100l);
                    user.setName("frozen");
                    user.setPassword("123456");
                    user.setEnabled(true);
                    user.setAddress("北京");
                    user.setRemark("remark");
                    user.setTelephone("13067970000");
                    user.setUserface("userface");
                    user.setCreateTime(new Date());
                    user.setUpdateTime(new Date());
                }
            }
        }
    }
    @Test
    public void test(){
        initUser();
        insert();
        update();
        getUserById();
        getByUsername();
        list();
        listAll();
        listByIds();
        delete();
    }

    @Test
    public void insert(){
        userMapper.insert(user);
    }
    @Test
    public void update(){
        userMapper.update(user);
    }
    @Test
    public void getUserById(){
        log.info(userMapper.getUserById(user.getId()).toString());
    }
    @Test
    public void getByUsername(){
        log.info(userMapper.getByUsername(user.getName()).toString());
    }
    @Test
    public void list(){
        log.info(userMapper.list(user).toString());
    }
    @Test
    public void listAll(){
        log.info(userMapper.listAll(user).toString());
    }
    @Test
    public void listByIds(){
        List<Long> ids =new ArrayList<>();
        ids.add(user.getId());
        log.info(userMapper.listByIds(ids).toString());
    }
    @Test
    public void delete(){
        userMapper.delete(user.getId());
    }
}
