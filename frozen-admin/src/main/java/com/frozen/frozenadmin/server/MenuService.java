package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.MenuMapper;
import com.frozen.frozenadmin.po.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Auther: frozen
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
