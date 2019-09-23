package com.lst.malls.service.impl;

import com.lst.malls.mapper.AdminMapper;
import com.lst.malls.pojo.Admin;
import com.lst.malls.pojo.AdminExample;
import com.lst.malls.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：Nibelung
 * @ Date      ：Created in 10:27 2019/9/5
 * @ Description :
 * @ Modified By :
 * @ Version : $
 */
@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminMapper adminMapper;

    /**
     * 查询Admin表里的账户数据
     *
     * @return admin
     */
    @Override
    public List<Admin> list(){
        AdminExample example = new AdminExample();
        //按 id 降序排序
        //使用list接受
        List<Admin> admins = adminMapper.selectByExampleNoPassword(example);

        return admins;
    }


    /**
     * 判断数据里是否有和参数相同的值
     *
     * return:boolean
     */
    @Override
    public Admin get(String name, String password) {
        AdminExample example = new AdminExample();

        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);

        List<Admin> admins = adminMapper.selectByExample(example);

        if (admins.isEmpty()){
            return null;
        }


        return admins.get(0);
    }



    /**
     *添加管理员账户
     * @param admin
     */
    @Override
    public void add(Admin admin){
        
         adminMapper.insert(admin);
    }

    /**
     * 删除管理员账户by id
     * @param id
     */
    @Override
    public void delete(Integer id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新管理员
     * @param admin
     */
    @Override
    public void update(Admin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
    }



    /**
     * 查重
     * @param name
     */
    @Override
    public boolean exist(String name) {
        AdminExample example = new AdminExample();

        example.createCriteria().andNameEqualTo(name);

        List<Admin> admins = adminMapper.selectByExample(example);

        if (admins.isEmpty()){

            return true;
        }
        return false;
    }

}
