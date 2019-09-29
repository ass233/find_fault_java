package com.zjjw.zjjwroute.service.im;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.net.MediaType;
import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.constant.Constant;
import com.zjjw.zjjwroute.vo.req.LoginReqVO;
import com.zjjw.zjjwroute.vo.res.ServerResVO;
import com.zjjw.zjjwserver.spi.res.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void saveRouteInfo(String userId, ServerResVO serverResVO) {
        String key = Constant.ROUTE_PREFIX + userId;
        redisTemplate.opsForValue().set(key, JSON.toJSONString(serverResVO));
    }

    public ServerResVO getRouteInfo(String userId) {
        String key = Constant.ROUTE_PREFIX + userId;
       return JSON.parseObject(redisTemplate.opsForValue().get(key),ServerResVO.class);
    }
}
