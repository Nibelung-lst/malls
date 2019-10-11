package com.lst.malls.service;

import com.lst.malls.pojo.User;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 9:54 2019/9/18
 * @Description :会员Service
 */
public interface UserService {


    /**
     * 展示
     * @return 会员对象数组
     */
    List<User> list();

    /**
     * 改变用户状态
     * @param change 用户状态
     * @param user 用户对象
     */
    void change(boolean change, User user);

    /**
     * 用户登录和注册
     * @param name 用户名
     * @param password 密码
     * @return
     */
    User get(String name,String password);

    /**
     * 用户注册功能（添加）
     * @param user 用户对象
     */
    void add(User user);

    /**
     * 用户名查重
     * @param name 用户名
     * @return boolean
     */
    boolean exist(String name);

    /**
     * 根据ID查询用户
     * @param userId 用户ID
     * @return 用户对象
     */
    User searchUserById(Integer userId);

    /**
     * 更新用户信息
     * @param user 用户对象
     */
    void updateUser(User user);


}
