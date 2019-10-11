package com.lst.malls.service;

import com.lst.malls.pojo.Category;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 9:47 2019/9/11
 * @Description :分类Service
 */


public interface CategoryService {

    /**
     * 根据主键查询
     * @param id 分类主键
     * @return 分类对象
     */
    Category selectById(Integer id);
    /**
     * 分类查询
     * @return 分类对象数组
     */
    List<Category> list();

    /**
     * 添加分类
     * @param category 分类对象
     */
    void add(Category category);


    /**
     * 查重
     * @param name 分类名
     * @return boolean
     */
    boolean exist(String name);


    /**
     * 按id删除
     * @param id 分类主键
     */
    void delete(Integer id);

    /**
     * 分类更新
     * @param category 分类对象
     */
    void update(Category category);
}
