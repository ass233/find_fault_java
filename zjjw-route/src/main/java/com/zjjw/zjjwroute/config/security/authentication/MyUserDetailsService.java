package com.zjjw.zjjwroute.config.security.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zjjw
 * @Date: 2019/4/20 16:41
 * @Description: userDetailsService 认证系统中的用户密码
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = "";
        boolean enabled = true;
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[] strArray = {};
        return User.withUsername(username).password(password).roles(strArray).disabled(enabled).accountExpired(true).accountLocked(true).credentialsExpired(true).build();
    }
}
