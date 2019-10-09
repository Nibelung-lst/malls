package com.lst.malls.service;

import com.lst.malls.pojo.Category;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 9:47 2019/9/11
 * @Description :
 * @Modified By :
 * @Version : $
 */


public interface CategoryService {

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Category selectById(Integer id);
    /**
     * 分类查询
     * @return
     */
    List<Category> list();

    /**
     * 添加分类
     * @param category
     */
    void add(Category category);


    /**
     * 查重
     * @param name
     * @return
     */
    boolean exist(String name);


    /**
     * 按id删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 分类更新
     * @param category
     */
    void update(Category category);
}
