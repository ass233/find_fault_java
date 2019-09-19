package com.frozen.frozenadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@Controller
@RequestMapping("/")
@Slf4j
public class IndexController {
    @RequestMapping(value = "index")
    public String index(){
        return "/index";
    }

    @ResponseBody
    @GetMapping(value = "/session")
    public Map<String, Object> getSession(HttpServletRequest request) {
        // 添加数据到Session
        request.getSession().setAttribute("username", "admin");
        // 添加sessionID到Map
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        return map;
    }

    @ResponseBody
    @GetMapping(value = "/get")
    public String get(HttpServletRequest request) {
        // 获取Session数据
        String userName = (String) request.getSession().getAttribute("username");
        return userName;
    }

    @ResponseBody
    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        // 销毁sessioin
        request.getSession().invalidate();
        return "ok";
    }
    @GetMapping("/session/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, Object> sessionInvalid(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 401);
        map.put("msg", "session失效，请重新登录");
        return map;
    }

    @GetMapping("/me")
    @ResponseBody
    public Object me() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @GetMapping("/me1")
    @ResponseBody
    public Object me1(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/me2")
    @ResponseBody
    public Object me2(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
