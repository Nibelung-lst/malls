package com.lst.malls.mapper;

import com.lst.malls.pojo.Category;
import com.lst.malls.pojo.CategoryExample;
import java.util.List;

/**
 * @Author:Nibelung
 */
public interface CategoryMapper {
    /**
     * 按主键删除
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 新增一个分类对象
     * @param record
     * @return
     */
    Integer insert(Category record);

    /**
     * 按条件查询分类
     * @param example
     * @return
     */
    List<Category> selectByExample(CategoryExample example);


    /**
     * 更新分类
     * @param record
     * @return
     */
    Integer update(Category record);

}