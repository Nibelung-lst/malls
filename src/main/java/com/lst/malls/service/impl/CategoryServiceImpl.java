package com.lst.malls.service.impl;

import com.lst.malls.mapper.CategoryMapper;
import com.lst.malls.pojo.Category;
import com.lst.malls.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 查询Category表里的分类数据
     *
     * @return admin
     */
    @Override
    public List<Category> list() {


        List<Category> categories = categoryMapper.select();

        return categories;
    }

    /**
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
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

        List<Category> categories = categoryMapper.selectByName(name);

        if (categories.isEmpty()){

            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Category category) {
        categoryMapper.update(category);

    }

}
