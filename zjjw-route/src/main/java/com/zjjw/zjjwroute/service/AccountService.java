package com.zjjw.zjjwroute.service;

import com.google.common.net.MediaType;
import com.zjjw.zjjwroute.constant.Constant;
import com.zjjw.zjjwroute.vo.req.LoginReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Auther: frozen
 * @Date: 2019/9/14 10:05
 * @Description:
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private MediaType mediaType = MediaType.parse("application/json");


    public void saveRouteInfo(LoginReqVO loginReqVO, String msg) throws Exception {
        String key = Constant.ROUTE_PREFIX + loginReqVO.getUserId();
        redisTemplate.opsForValue().set(key, msg);
    }
}
