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
     *
     * return: List<Admin>
     */
    List<Admin> list();

    /**
     * 判断数据里是否有和参数相同的值
     *
     * return:boolean
     */
    Admin get(String name,String password);

    /**
     * 添加管理员
    * */

    void add(Admin admin);

    /**
     *
     * 删除管理员账户By id
     */
    void delete(Integer id);

    /**
     *
     *更新管理员
     */
    void update(Admin admin);

    /**
     * 查重
     */
    boolean exist(String name);

}
