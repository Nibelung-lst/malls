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
     * 查询Admin表里的账户数据
     *
     * return: List<Admin>
     */
    List<Category> list();

    /**
     * 添加分类
     * */

    void add(Category category);


    /**
     * 查重
     */
    boolean exist(String name);


    /**
     *
     * 删除分类By id
     */
    void delete(Integer id);

    /**
     *
     *更新分类
     */
    void update(Category category);
}
