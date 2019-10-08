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
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     *
     * @return
     */
    @Override
    public List<User> list() {
        List<User> users = userMapper.select();
        return users;
    }

    /**
     *
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
     *
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
     *
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    /**
     *
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

    @Override
    public User searchUserById(Integer userId) {
        User user = userMapper.selectById(userId);
        return user;
    }

}
