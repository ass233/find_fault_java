package com.zjjw.zjjwroute.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.net.MediaType;
import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.constant.Constant;
import com.zjjw.zjjwroute.route.algorithm.RandomHandle;
import com.zjjw.zjjwroute.util.HttpUtils;
import com.zjjw.zjjwroute.vo.req.LoginReqVO;
import com.zjjw.zjjwserver.spi.res.MenuVo;
import com.zjjw.zjjwserver.spi.res.RoleVo;
import com.zjjw.zjjwserver.spi.res.UserRoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: frozen
 * @Date: 2019/9/14 10:05
 * @Description:
 */
@Service
@Slf4j
public class MenuService {
    @Autowired
    HttpUtils httpUtils;
    @Autowired
    RandomHandle randomHandle;

}
