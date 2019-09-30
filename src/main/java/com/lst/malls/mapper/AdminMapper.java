package com.lst.malls.mapper;

import com.lst.malls.pojo.Admin;
import com.lst.malls.pojo.AdminExample;
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
     * 新增一个管理员对象
     * @param record
     * @return
     */
    Integer insert(Admin record);
    /**
     * 根据条件进行查询
     * @param example
     * @return
     */
    List<Admin> selectByExample(AdminExample example);


    /**
     * 更新管理员对象
     * @param record
     * @return
     */
    Integer update(Admin record);

    /**
     * 按条件查询不带密码
     * @param example
     * @return
     */
    List<Admin> selectByExampleNoPassword(AdminExample example);

}