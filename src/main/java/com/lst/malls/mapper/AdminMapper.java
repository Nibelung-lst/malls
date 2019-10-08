package com.lst.malls.mapper;

import com.lst.malls.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:Nibelung
 */
public interface AdminMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 查询出用户名和密码
     * @return
     */
    List<Admin> select();

    /**
     * 新增一个管理员对象
     * @param record
     * @return
     */
    Integer insert(Admin record);

    /**
     * 查询用户和密码
     * @param name
     * @param password
     * @return
     */
    List<Admin> selectByNameAndPassword(@Param("name")String name,@Param("password")String password);
    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    List<Admin> selectByName(@Param("name")String name);

    /**
     * 更新管理员对象
     * @param record
     * @return
     */
    Integer update(Admin record);


}