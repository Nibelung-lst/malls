package com.lst.malls.service.impl;

import com.lst.malls.mapper.AdminMapper;
import com.lst.malls.pojo.Admin;
import com.lst.malls.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Date      ：Created in 10:27 2019/9/5
 * @Author：Nibelung
 * @ Description :管理员登录与展示service
 */
@Service
public class AdminServiceImpl implements AdminService {


    /**
     * 管理员表sql方法
     */
    @Autowired
    AdminMapper adminMapper;

    /**
     * 查询Admin表里的账户数据
     *
     * @return admin
     */
    @Override
    public List<Admin> list(){

        return adminMapper.select();
    }


    /**
     * 判断数据里是否有和参数相同的值
     *
     * return:boolean
     */
    @Override
    public Admin get(String name, String password) {

        List<Admin> admins = adminMapper.selectByNameAndPassword(name,password);

        if (admins.isEmpty()){
            return null;
        }


        return admins.get(0);
    }



    /**
     *添加管理员账户
     * @param admin 管理员对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Admin admin){
        
         adminMapper.insert(admin);
    }

    /**
     * 删除管理员账户by id
     * @param id 管理员主键
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        adminMapper.delete(id);
    }

    /**
     * 更新管理员
     * @param admin 管理员对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Admin admin) {
        adminMapper.update(admin);
    }



    /**
     * 查重
     * @param name 管理员名字
     * @return boolean
     */
    @Override
    public boolean exist(String name) {

        List<Admin> admins = adminMapper.selectByName(name);

        if (admins.isEmpty()){

            return true;
        }
        return false;
    }

}
