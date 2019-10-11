package com.lst.malls.service;

import com.lst.malls.pojo.Admin;

import java.util.List;
/**
 * @Author    :Nibelung
 * @Date      ：Created in 9:47 2019/9/11
 * @Description : 管理员service
 */
public interface AdminService {

    /**
     * 查询Admin表里的账户数据
     * @return 管理员对象数组
     */
    List<Admin> list();

    /**
     * 判断数据里是否有和参数相同的值
     * @param name 用户名
     * @param password 密码
     * @return 管理员账户对象
     */
    Admin get(String name,String password);

    /**
     * 添加管理员
     * @param admin 管理员对象
     */
    void add(Admin admin);

    /**
     * 删除管理员
     * @param id 管理员主键
     */
    void delete(Integer id);

    /**
     * 更新管理员
     * @param admin 管理员对象
     */
    void update(Admin admin);

    /**
     * 管理员名字查重
     * @param name 管理员名字
     * @return boolean
     */
    boolean exist(String name);

}
