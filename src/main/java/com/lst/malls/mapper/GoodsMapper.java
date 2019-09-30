package com.lst.malls.mapper;

import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.GoodsExample;
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
     * 新增一个商品
     * @param record
     * @return
     */
    Integer insert(Goods record);

    /**
     * 按条件查询商品信息
     * @param example
     * @return
     */
    List<Goods> selectByExample(GoodsExample example);

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
     * @param category_name
     * @return
     */
    List<Goods> selectByCategory(String category_name);

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