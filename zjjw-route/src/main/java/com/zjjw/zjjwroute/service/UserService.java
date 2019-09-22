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
public class UserService {
    /**
     * 获取用户密码
     * @param userName
     * @return
     * @throws Exception
     */
    public String getPassword(String userName){
        return "123456";
    }

}
