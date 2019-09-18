package com.zjjw.zjjwroute.controller;

import com.zjjw.common.enmus.StatusEnum;
import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.cache.ServerCache;
import com.zjjw.zjjwroute.route.algorithm.RandomHandle;
import com.zjjw.zjjwroute.service.AccountService;
import com.zjjw.zjjwroute.vo.req.LoginReqVO;
import com.zjjw.zjjwroute.vo.res.ServerResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: frozen
 * @Date: 2019/9/14 09:31
 * @Description:
 */
@Controller
@RequestMapping("/")
public class RouteController {
    @Autowired
    RandomHandle randomHandle;
    @Autowired
    private ServerCache serverCache;
    @Autowired
    AccountService accountService;
    /**
     *
     * @param loginReqVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody()
    public BaseResponse<ServerResVO> login(@RequestBody LoginReqVO loginReqVO) throws Exception {
        BaseResponse<ServerResVO> res = new BaseResponse();
        //登录校验
        StatusEnum status = StatusEnum.SUCCESS;
        String server = randomHandle.routeServer(serverCache.getAll(), String.valueOf(loginReqVO.getUserId()));
        String[] serverInfo = server.split(":");
        ServerResVO vo = new ServerResVO(serverInfo[0], Integer.parseInt(serverInfo[1]), Integer.parseInt(serverInfo[2]));
        //保存路由信息
        accountService.saveRouteInfo(loginReqVO, server);
        res.setDataBody(vo);
        res.setCode(status.getCode());
        res.setMessage(status.getMessage());
        return res;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getAllServer", method = RequestMethod.GET)
    @ResponseBody()
    public String getAllServer() throws Exception {
        return  randomHandle.routeServer(serverCache.getAll(),"");
    }
}
