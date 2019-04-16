package com.ming.ljs.service;

import com.ming.ljs.bean.User;

/**
 * created by ZMX
 * Date 2019/4/11 Time 15:27
 */
public interface UserService {

    /**
     * 判断用户名是否存在
     * @param name
     * @return
     */
    boolean findUserName(String name);

    /**
     * 通过用户名和密码查找完整的用户信息
     * @param user
     * @return 返回user表示用户信息存在,返回null表示用户帐号或密码存在不匹配
     */
    User login(User user);


    /**
     * 注册用户
     * @param user
     * @return 返回true表示注册成功,否则失败
     */
    boolean register(User user);

    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    User findUserbyName(String name);

}
