package com.lst.malls.mapper;

import com.lst.malls.pojo.ShoppingCar;
import com.lst.malls.pojo.ShoppingCarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author:Nibelung
 */
public interface ShoppingCarMapper {
    /**
     * 删除购物车
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 新增购物车
     * @param record
     * @return
     */
    Integer insert(ShoppingCar record);


    /**
     * 根据条件查询购物车
     * @param example
     * @return
     */
    List<ShoppingCar> selectByExample(ShoppingCarExample example);

    /**
     * 根据主键进行查询
     * @param id
     * @return
     */
    ShoppingCar selectById(Integer id);

    /**
     * 查询指定用户名和商品名下的购物车里的商品数量
     * @param userId
     * @param goodsId
     * @return
     */
    Integer selectByNumbers(@Param("user_id") Integer userId,@Param("goods_id") Integer goodsId);

    /**
     * 修改购物车的商品数量
     * @param userId
     * @param goodsId
     * @param numbers
     * @return
     */
    Integer updateByNumbers(@Param("user_id") Integer userId,@Param("goods_id") Integer goodsId,@Param("numbers") Integer numbers);

    /**
     * 查询用户的购物车有几件商品
     * @param userId
     * @return
     */
    Integer countByUserId(@Param("user_id") Integer userId);


}