package com.lst.malls.service;

import com.lst.malls.pojo.User;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 9:54 2019/9/18
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface UserService {


    /**
     * 展示
     * @return
     */
    List<User> list();

    /**
     * 改变用户状态
     * @param change
     * @param user
     */
    void change(boolean change, User user);

    /**
     * 用户登录和注册
     * @param name
     * @param password
     * @return
     */
    User get(String name,String password);

    /**
     * 用户注册功能（添加）
     * @param user
     */
    void add(User user);

    /**
     * 用户名查重
     * @param name
     * @return
     */
    boolean exist(String name);

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    User searchUserById(Integer userId);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);


}
