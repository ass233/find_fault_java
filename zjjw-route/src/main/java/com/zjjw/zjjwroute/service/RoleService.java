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
import com.zjjw.zjjwserver.spi.res.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
public class RoleService {
    @Autowired
    HttpUtils httpUtils;
    @Autowired
    RandomHandle randomHandle;

    /**
     * 获取用户角色
     * @param userId
     * @return
     * @throws Exception
     */
    public List<String> getRoles(Long userId){
        String url = randomHandle.getServerUrl("/getListByUserId");
        UserRoleVo userRoleVo = new UserRoleVo();
        userRoleVo.setUserId(userId);
        String json = httpUtils.sendMsg(url, JSON.toJSONString(userRoleVo));
        BaseResponse<List<RoleVo>> response= JSON.parseObject(json,new TypeReference<BaseResponse<List<RoleVo>>>() {});
        List<RoleVo> roleVos=response.getDataBody();
        return roleVos.stream().map(e->e.getName()).collect(Collectors.toList());
    }

    /**
     * 获取菜单需要的角色
     * @param requestUrl
     * @return
     * @throws Exception
     */
    public List<String> getNeedRoles(String requestUrl){
        String url = randomHandle.getServerUrl("/getListByMenuUrl");
        MenuVo menuVo = new MenuVo();
        menuVo.setUrl(requestUrl);
        String json = httpUtils.sendMsg(url, JSON.toJSONString(menuVo));
        BaseResponse<List<RoleVo>> response= JSON.parseObject(json,new TypeReference<BaseResponse<List<RoleVo>>>() {});
        List<RoleVo> roleVos=response.getDataBody();
        return roleVos.stream().map(e->e.getName()).collect(Collectors.toList());
    }
}
