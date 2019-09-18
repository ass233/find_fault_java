package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.po.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Auther: frozen
 * @Date: 2019/4/21 08:27
 * @Description:
 */
@Service
public class UserService {

    public User getByUsername(String username) {
        User user = new User();
        user.setEnabled(true);
        //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //user.setPassword(passwordEncoder.encode("123456"));
        user.setPassword("123456");
        return user;
    }
}
