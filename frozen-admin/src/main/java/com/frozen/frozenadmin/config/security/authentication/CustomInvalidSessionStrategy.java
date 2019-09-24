package com.frozen.frozenadmin.config.security.authentication;

import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Frozen
 * @create: 2019-09-19 13:42
 * @description: seesion失效策略
 **/
@Component
public class CustomInvalidSessionStrategy implements InvalidSessionStrategy {
    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 自定义session无效处理
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append("session无效，请重新登录");
    }
}
