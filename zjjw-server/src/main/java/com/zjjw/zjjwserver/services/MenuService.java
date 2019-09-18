package com.zjjw.zjjwserver.services;

import com.zjjw.zjjwserver.dao.MenuMapper;
import com.zjjw.zjjwserver.po.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Auther: zjjw
 * @Date: 2019/4/21 08:27
 * @Description:
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    /**
     * 获取所有菜单
     * @return
     */
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

}
