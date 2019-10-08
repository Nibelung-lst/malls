package com.lst.malls.mapper;

import com.lst.malls.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 分类mapper
 */
public interface CategoryMapper {
    /**
     * 按主键删除
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 查询所有分类信息
     * @return
     */
    List<Category> select();
    /**
     * 根据分类名查询
     * @param name
     * @return
     */
    List<Category> selectByName(@Param("name") String name);
    /**
     * 新增一个分类对象
     * @param record
     * @return
     */
    Integer insert(Category record);

    /**
     * 更新分类
     * @param record
     * @return
     */
    Integer update(Category record);

}