package com.ming.ljs.mapper;

import com.ming.ljs.bean.User;
import com.ming.ljs.bean.Vo;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 注册用户
     * @param record
     * @return 返回true表示注册成功,否则失败
     */
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);




    /**
     * 判断用户名是否存在
     * @param name
     * @return 返回int表示存在,返回0表示不存在
     */
    int findUserName(@Param("name") String name);

    /**
     * 通过用户名和密码查找完整的用户信息
     * @param user
     * @return 返回user表示用户信息存在,返回null表示用户帐号或密码存在不匹配
     */
    User login(User user);

    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    User findUserbyName(String name);

    /**
     * 通过用户名查找用户盐值
     * @param name
     * @return
     */
    String findUserSaltbyName(String name);
}