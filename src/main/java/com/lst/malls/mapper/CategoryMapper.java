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
     * 根据主键查询分类
     * @param id 分类主键
     * @return 分类对象
     */
    Category selectById(Integer id);
    /**
     * 按主键删除
     * @param id 分类主键
     * @return 删除成功
     */
    Integer delete(Integer id);

    /**
     * 查询所有分类信息
     * @return 分类对象数组
     */
    List<Category> select();
    /**
     * 根据分类名查询
     * @param name 分类名
     * @return 分类对象数组
     */
    List<Category> selectByName(@Param("name") String name);
    /**
     * 新增一个分类对象
     * @param record 分类对象
     * @return 插入成功
     */
    Integer insert(Category record);

    /**
     * 更新分类
     * @param record 分类对象
     * @return 更新成功
     */
    Integer update(Category record);

}