package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.MenuMapper;
import com.frozen.frozenadmin.po.Menu;
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
public class MenuServiceTests {
    @Autowired
    MenuMapper menuMapper;
    private Menu menu;

    public void initMenu(){
        if(menu==null) {
            synchronized (MenuServiceTests.class) {
                if(menu==null) {
                    menu = new Menu();
                    menu.setId(100l);
                    menu.setName("frozen");
                    menu.setEnabled(true);
                    menu.setCreateTime(new Date());
                    menu.setUpdateTime(new Date());
                }
            }
        }
    }
    @Test
    public void test(){
        initMenu();
        insert();
        update();
        getById();
        list();
        list();
        getAllMenu();
        listByIds();
        delete();
    }
    public void insert(){
        menuMapper.insert(menu);
    }

    public void delete(){
        menuMapper.delete(menu.getId());
    }

    public void update(){
        menuMapper.update(menu);
    }

    public void getById(){
        menuMapper.getById(menu.getId());
    }

    public void list(){
        menuMapper.list(menu);
    }

    public void getAllMenu(){
        menuMapper.getAllMenu();
    }

    public void listByIds(){
        List<Long> ids = new ArrayList<>();
        ids.add(menu.getId());
        menuMapper.listByIds(ids);
    }
}
