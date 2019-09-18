package com.lst.malls.service.impl;

import com.lst.malls.mapper.CategoryMapper;
import com.lst.malls.pojo.Category;
import com.lst.malls.pojo.CategoryExample;
import com.lst.malls.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 10:05 2019/9/11
 * @Description :
 * @Modified By :
 * @Version : $
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    /**
     * 查询Category表里的账户数据
     *
     * @return admin
     */
    @Override
    public List<Category> list() {

        CategoryExample example = new CategoryExample();

        List<Category> categories = categoryMapper.selectByExample(example);

        return categories;
    }

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);

    }

    /**
     * 查重
     * @param name
     */
    @Override
    public boolean exist(String name) {
        CategoryExample example = new CategoryExample();
        //通过 name 调用Example里的方法进行校验
        example.createCriteria().andNameEqualTo(name);
        //如果数据库内有字段相同的name，就给categories赋值
        List<Category> categories = categoryMapper.selectByExample(example);

        if (categories.isEmpty()){

            return true;
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);

    }

}
