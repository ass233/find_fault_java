package com.zjjw.zjjwroute.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjjw.common.res.BaseResponse;
import com.zjjw.zjjwroute.config.security.UserRoute;
import com.zjjw.zjjwroute.route.algorithm.RandomHandle;
import com.zjjw.zjjwroute.service.im.AccountService;
import com.zjjw.zjjwroute.util.SpringBeanFactory;
import com.zjjw.zjjwroute.vo.res.ServerResVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: zjjw
 * @Date: 2019/4/20 16:50
 * @Description: 登录成功的处理
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
        this.saveUserServerInfo();
        resp.setContentType("application/json;charset=utf-8");
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(BaseResponse.createSuccess("登录成功!")));
        out.flush();
        out.close();
    }

    /**
     * 保存用户路由信息
     */
    private void saveUserServerInfo(){
        UserRoute userDetails = (UserRoute) SecurityContextHolder.getContext() .getAuthentication() .getPrincipal();
        String server = SpringBeanFactory.getBean(RandomHandle.class).routeServer(String.valueOf(userDetails.getUserId()));
        String[] serverInfo = server.split(":");
        ServerResVO serverResVO = new ServerResVO();
        serverResVO.setIp(serverInfo[0]);
        serverResVO.setCimServerPort(Integer.parseInt(serverInfo[1]));
        serverResVO.setHttpPort(Integer.parseInt(serverInfo[2]));
        SpringBeanFactory.getBean(AccountService.class).saveRouteInfo(String.valueOf(userDetails.getUserId()), serverResVO);
    }
}
