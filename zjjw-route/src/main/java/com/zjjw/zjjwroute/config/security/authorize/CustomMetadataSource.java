package com.zjjw.zjjwroute.config.security.authorize;

import com.zjjw.zjjwroute.service.MenuService;
import com.zjjw.zjjwroute.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Auther: zjjw
 * @Date: 2019/4/20 19:21
 * @Description: 当访问一个url时返回这个url所需要的访问权限
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    MenuService menuService;
    @Autowired
    RoleService roleService;

    /**
     *
     * @param o
     * @return 本次访问需要的权限,如果没有匹配的url直接返回null，也就是没有配置权限的url默认都为白名单，想要换成默认是黑名单只要修改这里即可。
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {
        return SecurityConfig.createList("ROLE_LOGIN");
//        String requestUrl = ((FilterInvocation) o).getRequestUrl();
//        List<String> roles = roleService.getNeedRoles(requestUrl);
//        String[] roleStrs = new String[roles.size()];
//        return SecurityConfig.createList(roleStrs);
        //没有匹配上的资源，都是登录访问
    }
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
