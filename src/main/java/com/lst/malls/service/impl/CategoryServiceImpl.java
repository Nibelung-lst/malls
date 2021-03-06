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
 * @Description :分类管理与显示service
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     * 分类表的sql方法
     */
    @Autowired
    CategoryMapper categoryMapper;
    /**
     * 根据主键进行查找
     * @param id 分类主键
     * @return 分类对象
     */
    @Override
    public Category selectById(Integer id) {
        Category category = categoryMapper.selectById(id);
        return category;
    }
    /**
     * 查询Category表里的分类数据
     * @return admin
     */
    @Override
    public List<Category> list() {
        List<Category> categories = categoryMapper.select();
        return categories;
    }

    /**
     * 添加分类
     * @param category 分类对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    /**
     * 查重
     * @param name 分类名
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
     * 按id删除
     * @param id 分类主键
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }

    /**
     * 分类更新
     * @param category 分类对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Category category) {
        categoryMapper.update(category);

    }

}
