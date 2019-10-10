package com.zjjw.zjjwserver.controller.im;

import com.zjjw.common.enmus.MsgTypeEnum;
import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwserver.services.im.HttpMsgGroupHandler;
import com.zjjw.zjjwserver.services.im.HttpMsgHandler;
import com.zjjw.zjjwserver.services.im.MsgHandler;
import com.zjjw.zjjwserver.spi.req.ImMsgVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
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
	@Autowired
	HttpMsgGroupHandler groupHandler;

    @RequestMapping(value = "sendMsg")
    @ResponseBody
    public BaseResponse sendMsg(@RequestBody ImMsgVo msgVo){
        log.info("msgVo={}",  msgVo);
        if(msgVo==null){
            return  BaseResponse.createFail("不能发送空消息！");
        }
        String userId =String.valueOf(msgVo.getUserId());
        String receiverId =String.valueOf(msgVo.getReceiverId());
        String msg = msgVo.getMsg();
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
        if (StringUtils.isEmpty(msg)) {
            return  BaseResponse.createFail("不能发送空消息！");
        }
        String result ;
	    if(MsgTypeEnum.PRIVATE.code().equals(msgVo.getType())){
		    result =httpMsgHandler.sendMsg(userId,receiverId,msg);
	    }else {
		    result =groupHandler.sendMsg(userId,receiverId,msg);
	    }
        if(StringUtils.isEmpty(result)){
            return BaseResponse.createSuccess();
        }else {
            return  BaseResponse.createFail(result);
        }
    }
}
