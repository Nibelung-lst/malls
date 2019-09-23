package com.lst.malls.service;

import com.lst.malls.pojo.Admin;

import java.util.List;
/**
 *@author Nibelung
 * Admin接口类
*/
public interface AdminService {

    /**
     * 查询Admin表里的账户数据
     * @return
     */
    List<Admin> list();

    /**
     * 判断数据里是否有和参数相同的值
     * @param name
     * @param password
     * @return
     */
    Admin get(String name,String password);

    /**
     * 添加管理员
     * @param admin
     */
    void add(Admin admin);

    /**
     * 删除管理员
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新管理员
     * @param admin
     */
    void update(Admin admin);

    /**
     * 管理员名字查重
     * @param name
     * @return
     */
    boolean exist(String name);

}
