package com.lst.malls.mapper;

import com.lst.malls.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 用户mapper
 */
public interface UserMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> select();
    /**
     * 根据用户名和密码进行查询
     * @param name
     * @param password
     * @return
     */
    List<User> selectByNameAndPassword(@Param("name")String name,@Param("password")String password);

    /**
     * 根据用户名进行查询
     * @param name
     * @return
     */
    List<User> selectByName(@Param("name")String name);
    /**
     * 新增用户
     * @param record
     * @return
     */
    Integer insert(User record);

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
     * 修改用户积分
     * @param point
     * @param userId
     * @return
     */
    Integer updateByPoint(@Param("point")Integer point,@Param("id")Integer userId);
}