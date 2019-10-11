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
     * @return 用户对象数组
     */
    List<User> select();
    /**
     * 根据用户名和密码进行查询
     * @param name 用户名
     * @param password 密码
     * @return 用户对象数组
     */
    List<User> selectByNameAndPassword(@Param("name")String name,@Param("password")String password);

    /**
     * 根据用户名进行查询
     * @param name 用户名
     * @return 用户对象数组
     */
    List<User> selectByName(@Param("name")String name);
    /**
     * 新增用户
     * @param record 用户对象
     * @return 新增成功
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
     * @param record 用户对象
     * @return 更新成功
     */
    Integer update(User record);

    /**
     * 修改用户积分
     * @param point 修改的积分
     * @param userId 用户ID
     * @return 修改成功
     */
    Integer updateByPoint(@Param("point")Integer point,@Param("id")Integer userId);
}