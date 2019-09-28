package com.zjjw.zjjwserver.controller.im;

import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwserver.services.im.HttpMsgHandler;
import com.zjjw.zjjwserver.services.im.MsgHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@Controller
@RequestMapping("/")
@Slf4j
public class SendController {

    @Autowired
    HttpMsgHandler httpMsgHandler;

    @RequestMapping(value = "sendMsg")
    @ResponseBody
    public BaseResponse sendMsg(@RequestParam String userId, String receiverId, String msg){
        log.info("userId={},receiverId={},msg={}",userId, receiverId,  msg);
        //发送人为空
        if(StringUtils.isEmpty(userId)){
            log.error("userId null receiverId={},msg={}",receiverId,msg);
            return  BaseResponse.createFail("发送用户ID不能为空");
        }
        //接收人为空
        if( StringUtils.isEmpty(receiverId)){
            log.error("receiverId null userId={},msg={}",userId,msg);
            return  BaseResponse.createFail("接收者ID不能为空");
        }
        String result = httpMsgHandler.sendMsg( userId,receiverId,msg) ;
        if(StringUtils.isEmpty(result)){
            return BaseResponse.createSuccess();
        }else {
            return  BaseResponse.createFail(result);
        }
    }
}
