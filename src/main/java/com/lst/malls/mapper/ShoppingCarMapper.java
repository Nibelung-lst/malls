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
    int delete(Integer id);

    /**
     * 新增购物车
     * @param record
     * @return
     */
    int insert(ShoppingCar record);


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
     * @param user_id
     * @param goods_id
     * @return
     */
    Integer selectByNumbers(@Param("user_id") Integer user_id,@Param("goods_id") Integer goods_id);

    /**
     * 修改购物车的商品数量
     * @param user_id
     * @param goods_id
     * @param numbers
     * @return
     */
    int updateByNumbers(@Param("user_id") Integer user_id,@Param("goods_id") Integer goods_id,@Param("numbers") Integer numbers);


}