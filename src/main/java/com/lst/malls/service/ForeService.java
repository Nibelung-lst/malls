package com.lst.malls.service;

import com.lst.malls.pojo.*;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 10:44 2019/9/26
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface ForeService {


    /**
     * 立即购买
     * @param id
     * @param num
     * @param goods
     * @return
     */
    OrderDetail puyNow(Integer id, Integer num, Goods goods);


    /**
     * 创建订单
     * @param order
     * @param orderDetails
     * @param user
     * @return
     */
    Order creatOrder(Order order,List<OrderDetail> orderDetails, User user);

    /**
     *添加购物车
     * @param userId
     * @param goodsId
     * @param numbers
     * @return
     */
    void shoppingCarAdd(Integer userId,Integer goodsId,Integer numbers);

    /**
     *根据用户名查询购物车内容
     * @param userId
     * @return
     */
    List<ShoppingCar> selectShoppingByUserId(Integer userId);

    /**
     * 通过用户ID和商品ID查询是否有相应的购物车商品信息存在
     * @param userId
     * @param goodsId
     * @return
     */
    boolean selectShoppingCarByGoodsAndUser(Integer userId,Integer goodsId);


    /**
     * 增加商品数量
     * @param userId
     * @param goodsId
     * @param numbers
     */
    void updateGoodsNumbers(Integer userId,Integer goodsId,Integer numbers);

    /**
     * 删除购物车的某一商品信息
     * @param id
     */
    void deleteShoppingCar(Integer id);

    /**
     * 根据购物车主键查询购物车内容
     * @param id
     * @return
     */
    ShoppingCar selectShoppingCar(Integer id);

    /**
     * 查询用户的购物车里有几件商品
     * @param userId
     * @return
     */
    Integer countShoppingCayByUser(Integer userId);

    /**
     * 根据关键字查询
     * @param goodsName
     * @return
     */
    List<Goods> searchGoodsByKeyWord(String goodsName);

}
