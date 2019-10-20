package com.zjjw.zjjwroute.service.im;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zjjw.common.enmus.StatusEnum;
import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.route.algorithm.RandomHandle;
import com.zjjw.zjjwroute.util.HttpUtils;
import com.zjjw.zjjwroute.vo.res.ServerResVO;
import com.zjjw.zjjwserver.spi.req.ImMsgVo;
import com.zjjw.zjjwserver.spi.res.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: frozen
 * @Date: 2019/9/14 10:05
 * @Description:
 */
@Service
@Slf4j
public class SendService {
    @Autowired
    HttpUtils httpUtils;
    @Autowired
    RandomHandle randomHandle;
    @Autowired
    AccountService accountService;

    /**
     * 发送消息
     * @param msgVo
     * @return
     */
    public BaseResponse sendMsg(ImMsgVo msgVo){
        String userId = String.valueOf(msgVo.getReceiverId());
        ServerResVO serverResVO = accountService.getRouteInfo(userId);
        if(serverResVO==null){
            return BaseResponse.createFail("用户不在线");
        }
        String url = randomHandle.getImServerUrl(serverResVO,"/im/sendMsg");
        String json = httpUtils.sendMsg(url, JSON.toJSONString(msgVo));
        return JSON.parseObject(json,new TypeReference<BaseResponse<UserVo>>() {});
    }

}
