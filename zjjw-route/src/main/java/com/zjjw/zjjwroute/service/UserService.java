package com.zjjw.zjjwroute.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.net.MediaType;
import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.constant.Constant;
import com.zjjw.zjjwroute.route.algorithm.RandomHandle;
import com.zjjw.zjjwroute.util.HttpUtils;
import com.zjjw.zjjwroute.vo.req.LoginReqVO;
import com.zjjw.zjjwserver.spi.res.UserVo;
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
    @Autowired
    HttpUtils httpUtils;
    @Autowired
    RandomHandle randomHandle;

    /**
     * 获取用户密码
     * @param userName
     * @return
     * @throws Exception
     */
    public UserVo getPasswordByUserName(String userName){
        String url = randomHandle.getServerUrl("/getUserByUserName");
        UserVo userVo = new UserVo();
        userVo.setName(userName);
        String json = httpUtils.sendMsg(url, JSON.toJSONString(userVo));
        BaseResponse<UserVo> response= JSON.parseObject(json,new TypeReference<BaseResponse<UserVo>>() {});
        UserVo responseUserVo=response.getDataBody();
        return responseUserVo;
    }

}
