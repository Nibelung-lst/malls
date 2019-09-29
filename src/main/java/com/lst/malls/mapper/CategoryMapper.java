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
    int delete(Integer id);

    /**
     * 新增一个分类对象
     * @param record
     * @return
     */
    int insert(Category record);

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
    int update(Category record);

}