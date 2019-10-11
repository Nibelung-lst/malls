package com.lst.malls.mapper;

import com.lst.malls.pojo.ShoppingCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 购物车mapper
 */
public interface ShoppingCarMapper {
    /**
     * 删除购物车
     * @param id 购物车主键
     * @return 删除成功
     */
    Integer delete(Integer id);

    /**
     * 新增购物车
     * @param record 购物车对象
     * @return 新增成功
     */
    Integer insert(ShoppingCar record);

    /**
     * 根据用户ID查询购物车
     * @param userId 用户主键
     * @return 购物车对象数组
     */
    List<ShoppingCar> selectByUserId(@Param("user_id") Integer userId);

    /**
     * 根据用户ID和商品ID查询购物车
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @return 购物车对象数组
     */
    List<ShoppingCar> selectByUserIdAndGoodsId(@Param("user_id") Integer userId,@Param("goods_id")Integer goodsId);

    /**
     * 根据主键进行查询
     * @param id 购物车主键
     * @return 购物车对象
     */
    ShoppingCar selectById(Integer id);

    /**
     * 查询指定用户名和商品名下的购物车里的商品数量
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @return 商品数量
     */
    Integer selectByNumbers(@Param("user_id") Integer userId,@Param("goods_id") Integer goodsId);

    /**
     * 修改购物车的商品数量
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param numbers 商品数量
     * @return 修改成功
     */
    Integer updateByNumbers(@Param("user_id") Integer userId,@Param("goods_id") Integer goodsId,@Param("numbers") Integer numbers);

    /**
     * 查询用户的购物车有几件商品
     * @param userId 用户ID
     * @return 商品数量
     */
    Integer countByUserId(@Param("user_id") Integer userId);


}