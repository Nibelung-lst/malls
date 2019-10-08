package com.lst.malls.mapper;

import com.lst.malls.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:Nibelung
 */
public interface GoodsMapper {
    /**
     * 按主键删除
     * @param id
     * @return
     */
    Integer delete(Integer id);
    /**
     * 查询出所有商品信息
     * @return
     */
    List<Goods> select();
    /**
     * 新增一个商品
     * @param record
     * @return
     */
    Integer insert(Goods record);

    /**
     * 根据商品Id查询商品
     * @param id
     * @return
     */
    Goods selectById(Integer id);

    /**
     * 更新商品信息
     * @param record
     * @return
     */
    Integer update(Goods record);

    /**
     * 根据分类查询商品
     * @param categoryName
     * @return
     */
    List<Goods> selectByCategory(@Param("category_name") String categoryName);

    /**
     * 根据商品名字查询商品
     * @param name
     * @return
     */
    Goods selectByName(String name);

    /**
     * 关键字查询
     * @param goodsName
     * @return
     */
    List<Goods> selectByKeyWord(@Param("name") String goodsName);
}