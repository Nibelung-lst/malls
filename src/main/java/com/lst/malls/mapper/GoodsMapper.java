package com.lst.malls.mapper;

import com.lst.malls.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 商品mapper
 */
public interface GoodsMapper {
    /**
     * 按主键删除
     * @param id 商品主键
     * @return 删除成功
     */
    Integer delete(Integer id);
    /**
     * 查询出所有商品信息
     * @return 商品对象数组
     */
    List<Goods> select();
    /**
     * 新增一个商品
     * @param record 商品对象
     * @return 添加成功
     */
    Integer insert(Goods record);

    /**
     * 根据商品Id查询商品
     * @param id 商品主键
     * @return 商品对象
     */
    Goods selectById(Integer id);

    /**
     * 更新商品信息
     * @param record 商品对象
     * @return 更新成功
     */
    Integer update(Goods record);

    /**
     * 根据分类查询商品
     * @param categoryName 分类名
     * @return 商品对象数组
     */
    List<Goods> selectByCategory(@Param("category_name") String categoryName);

    /**
     * 根据商品名字查询商品
     * @param name 商品名
     * @return 商品对象
     */
    Goods selectByName(String name);

    /**
     * 关键字查询
     * @param goodsName 商品名（关键字）
     * @return 商品对象数组
     */
    List<Goods> selectByKeyWord(@Param("name") String goodsName);
}