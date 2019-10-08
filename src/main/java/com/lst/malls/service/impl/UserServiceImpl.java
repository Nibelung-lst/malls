package com.lst.malls.service.impl;

import com.lst.malls.mapper.UserMapper;
import com.lst.malls.pojo.User;
import com.lst.malls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 9:54 2019/9/18
 * @Description :用户管理service
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 用户表的sql方法
     */
    @Autowired
    UserMapper userMapper;

    /**
     * 展示
     * @return
     */
    @Override
    public List<User> list() {
        List<User> users = userMapper.select();
        return users;
    }

    /**
     * 改变用户状态
     * @param change
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void change(boolean change,User user){
        if (change){
            user.setStatus(true);
            userMapper.update(user);
        }
        else {
            user.setStatus(false);
            userMapper.update(user);
        }
    }

    /**
     * 用户登录和注册
     * @param name
     * @param password
     * @return
     */
    @Override
    public User get(String name, String password) {

        List<User> admins = userMapper.selectByNameAndPassword(name,password);

        if (admins.isEmpty()){
            return null;
        }


        return admins.get(0);
    }

    /**
     * 用户注册功能（添加）
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    /**
     * 用户名查重
     * @param name
     * @return
     */
    @Override
    public boolean exist(String name) {
        List<User> users = userMapper.selectByName(name);

        if (users.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    @Override
    public User searchUserById(Integer userId) {
        User user = userMapper.selectById(userId);
        return user;
    }

}
