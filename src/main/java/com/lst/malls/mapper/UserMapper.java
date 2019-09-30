package com.lst.malls.mapper;

import com.lst.malls.pojo.User;
import com.lst.malls.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

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
    Integer insert(User record);

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
    Integer update(User record);

    /**
     * 不挟带密码的条件查询
     * @param example
     * @return
     */
    List<User> selectByNoPassword(UserExample example);

    /**
     * 修改用户积分
     * @param point
     * @param userId
     * @return
     */
    Integer updateByPoint(@Param("point")Integer point,@Param("id")Integer userId);
}