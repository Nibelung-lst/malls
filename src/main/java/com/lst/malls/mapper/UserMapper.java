package com.lst.malls.mapper;

import com.lst.malls.pojo.User;
import com.lst.malls.pojo.UserExample;
import java.util.List;
/**
 * @Author:Nibelung
 */
public interface UserMapper {

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 根据条件查询用户信息
     * @param example
     * @return
     */
    List<User> selectByExample(UserExample example);

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 更新用户信息
     * @param record
     * @return
     */
    int update(User record);

    /**
     * 不挟带密码的条件查询
     * @param example
     * @return
     */
    List<User> selectByNoPassword(UserExample example);
}