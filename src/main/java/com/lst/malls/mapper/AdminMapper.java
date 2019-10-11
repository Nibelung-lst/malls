package com.lst.malls.mapper;

import com.lst.malls.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 管理员mapper
 */
public interface AdminMapper {
    /**
     * 根据主键删除
     * @param id 主键
     * @return 删除成功
     */
    Integer delete(Integer id);

    /**
     * 查询出用户名和密码
     * @return 管理员实体类数组
     */
    List<Admin> select();

    /**
     * 新增一个管理员对象
     * @param record 管理员对象
     * @return 插入成功
     */
    Integer insert(Admin record);

    /**
     * 查询用户和密码
     * @param name 用户名
     * @param password 密码
     * @return 管理员实体类数组
     */
    List<Admin> selectByNameAndPassword(@Param("name")String name,@Param("password")String password);
    /**
     * 根据用户名查询
     * @param name 用户名
     * @return 管理员实体类数组
     */
    List<Admin> selectByName(@Param("name")String name);

    /**
     * 更新管理员对象
     * @param record 管理员实体类
     * @return 更新成功
     */
    Integer update(Admin record);


}