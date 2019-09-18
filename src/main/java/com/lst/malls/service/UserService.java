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

    void change(boolean change, User user);
}
