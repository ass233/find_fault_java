package com.zjjw.zjjwroute.controller.im;

import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.config.security.UserRoute;
import com.zjjw.zjjwroute.route.algorithm.RandomHandle;
import com.zjjw.zjjwroute.service.im.AccountService;
import com.zjjw.zjjwroute.vo.res.ServerResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    AccountService accountService;

    /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "imLogin", method = RequestMethod.POST)
    @ResponseBody()
    public BaseResponse<ServerResVO> login() throws Exception {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext() .getAuthentication() .getPrincipal();
        String server = randomHandle.routeServer(userDetails.getUsername());
        String[] serverInfo = server.split(":");
        ServerResVO serverResVO = new ServerResVO();
        serverResVO.setIp(serverInfo[0]);
        serverResVO.setCimServerPort(Integer.parseInt(serverInfo[1]));
        serverResVO.setHttpPort(Integer.parseInt(serverInfo[2]));
        //保存路由信息
        accountService.saveRouteInfo(userDetails.getUsername(), serverResVO);
        return BaseResponse.createSuccess();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getUserServer", method = RequestMethod.GET)
    @ResponseBody()
    public BaseResponse getUserServer() throws Exception {
        UserRoute userDetails = (UserRoute) SecurityContextHolder.getContext() .getAuthentication() .getPrincipal();
        ServerResVO serverResVO = accountService.getRouteInfo(String.valueOf(userDetails.getUserId()));
        return  BaseResponse.createSuccess(serverResVO);
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getAllServer", method = RequestMethod.GET)
    @ResponseBody()
    public BaseResponse getAllServer() throws Exception {
        return  BaseResponse.createSuccess(randomHandle.routeServer(""));
    }
}
