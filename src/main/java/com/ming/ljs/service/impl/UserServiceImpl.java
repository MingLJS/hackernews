package com.ming.ljs.service.impl;

import com.ming.ljs.bean.User;
import com.ming.ljs.mapper.UserMapper;
import com.ming.ljs.service.UserService;
import com.ming.ljs.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by ZMX
 * Date 2019/4/11 Time 15:28
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public boolean findUserName(String name) {
        int i = userMapper.findUserName(name);
        return i != 0 ;
    }

    @Override
    public User login(User user) {
        int salt = Integer.valueOf(userMapper.findUserSaltbyName(user.getName()));
        user.setPassword(MD5Utils.getMD5(user.getPassword(),salt));
        user = userMapper.login(user);
        return user;
    }

    @Override
    public boolean register(User user) {
        int salt = (int) ((Math.random()*100)%100);
        user.setSalt(String.valueOf(salt));
        user.setPassword(MD5Utils.getMD5(user.getPassword(),salt));
        int i = userMapper.insert(user);
        return i == 1 ;
    }

    @Override
    public User findUserbyName(String name) {
        User user = userMapper.findUserbyName(name);
        return user;
    }
}
