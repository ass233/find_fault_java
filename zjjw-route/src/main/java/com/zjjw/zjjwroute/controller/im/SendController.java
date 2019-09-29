package com.zjjw.zjjwroute.controller.im;

import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.service.im.SendService;
import com.zjjw.zjjwserver.spi.req.ImMsgVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    SendService sendService;

    @RequestMapping(value = "sendMsg")
    @ResponseBody
    public BaseResponse sendMsg(@RequestBody ImMsgVo msgVo){
        log.info("msgVo={}",  msgVo);
        //发送人为空
        if(msgVo==null){
            log.error("msg null ");
            return  BaseResponse.createFail("发送消息不能为空");
        }
        return sendService.sendMsg(msgVo);
    }
}
