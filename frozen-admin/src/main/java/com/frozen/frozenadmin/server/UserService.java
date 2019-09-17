package com.frozen.frozenadmin.server;

import com.frozen.frozenadmin.dao.UserMapper;
import com.frozen.frozenadmin.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: frozen
 * @Date: 2019/4/21 08:27
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    public int delete(Long userId) {
        return userMapper.delete(userId);
    }
}
