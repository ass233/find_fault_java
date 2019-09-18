package com.frozen.frozenadmin.config.security.authorize;

import com.frozen.frozenadmin.po.Role;
import com.frozen.frozenadmin.server.RoleService;
import com.frozen.frozenadmin.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: frozen
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
        com.frozen.frozenadmin.po.User user = userService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或者密码不正确");
        }
        String password = user.getPassword();
        password = (new BCryptPasswordEncoder()).encode(password);
        //用户具有的权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = roleService.getRolesByUserId(user.getId());
        String[] strArray = new String[roles.size()];
        for(int i=0;i<roles.size();i++){
            strArray[i]=roles.get(i).getName();
        }
        return User.withUsername(username).password(password).roles(strArray).disabled(false).accountExpired(false).accountLocked(false).credentialsExpired(false).build();
    }
}
