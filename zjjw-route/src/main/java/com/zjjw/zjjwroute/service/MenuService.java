package com.zjjw.zjjwroute.service;

import com.google.common.net.MediaType;
import com.zjjw.zjjwroute.constant.Constant;
import com.zjjw.zjjwroute.vo.req.LoginReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: frozen
 * @Date: 2019/9/14 10:05
 * @Description:
 */
@Service
@Slf4j
public class MenuService {

    /**
     * 获取菜单需要的角色
     * @param url
     * @return
     * @throws Exception
     */
    public List<String> getNeedRoles(String url){
        List<String> roles = new ArrayList<>();
        return roles;
    }
}
