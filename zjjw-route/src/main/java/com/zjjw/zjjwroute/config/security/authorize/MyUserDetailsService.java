package com.zjjw.zjjwroute.config.security.authorize;


import com.zjjw.zjjwroute.config.security.UserRoute;
import com.zjjw.zjjwroute.service.RoleService;
import com.zjjw.zjjwroute.service.UserService;
import com.zjjw.zjjwserver.spi.res.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: zjjw
 * @Date: 2019/4/20 16:41
 * @Description: userDetailsService 认证系统中的用户密码
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = userService.getPasswordByUserName(username);
        String pd =null ;
        if(userVo!=null){
            pd=userVo.getPassword();
        }
        String password = (new BCryptPasswordEncoder()).encode(pd);
        List<String> rolestr =roleService.getRoles(userVo.getId());
        UserRoute userRoute = new UserRoute(username,password,getRoles(rolestr));
        userRoute.setUserId(userVo.getId());
        return userRoute;
    }

    /**
     * 构建角色
     * @param roles
     * @return
     */
    private Collection<GrantedAuthority> getRoles(List<String> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        for (String role : roles){
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            list.add(grantedAuthority);
        }
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_LOGIN");
        list.add(grantedAuthority);
        return list;
    }
}
