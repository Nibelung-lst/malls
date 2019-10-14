package com.lst.malls.service.impl;

import com.lst.malls.mapper.GoodsMapper;
import com.lst.malls.mapper.ShoppingCarMapper;
import com.lst.malls.pojo.*;
import com.lst.malls.service.ForeService;
import com.lst.malls.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 10:45 2019/9/26
 * @Description :前台功能service
 */
@Service
public class ForeServiceImpl implements ForeService {

    /**
     * 订单详情表的sql方法
     */
    @Autowired
    OrderDetailService orderDetailService;
    /**
     * 购物车表的sql方法
     */
    @Autowired
    ShoppingCarMapper shoppingCarMapper;
    /**
     * 商品表的sql方法
     */
    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 立即购买
     * @param goodsId 商品ID
     * @param goodsNumber 商品数量
     * @param goods 商品对象
     * @return 订单详情对象
     */
    @Override
    public OrderDetail puyNow(Integer goodsId, Integer goodsNumber, Goods goods) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setNumber(goodsNumber);
        orderDetail.setGoodsId(goodsId);
        orderDetail.setGoods(goods);
        return orderDetail;
    }

    /**
     * 创建订单
     * @param order 订单对象
     * @param orderDetails 订单详情对象
     * @param user 用户对象
     * @return 订单对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Order creatOrder(Order order, List<OrderDetail> orderDetails, User user) {
        //生成订单号
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String timeStr = sdf.format(new Date());
        // 17位时间+用户id
        Long i = Long.valueOf(timeStr + user.getId());
        order.setOrderDetails(orderDetails);
        for (OrderDetail o:orderDetails) {
            o.setOrderId(i);
            orderDetailService.add(o);
        }
        //将订单ID和创建时间存入到订单中
        order.setOrderId(i);
        order.setCreatorTime(new Date());
        return order;
    }

    /**
     *添加购物车
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param numbers 商品数量
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void shoppingCarAdd(Integer userId, Integer goodsId, Integer numbers) {
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setUserId(userId);
        shoppingCar.setGoodsId(goodsId);
        shoppingCar.setNumbers(numbers);
        shoppingCarMapper.insert(shoppingCar);
    }

    /**
     *根据用户名查询购物车内容
     * @param userId 用户ID
     * @return 购物车对象数组
     */
    @Override
    public List<ShoppingCar> selectShoppingByUserId(Integer userId) {

        return shoppingCarMapper.selectByUserId(userId);
    }

    /**
     * 通过用户ID和商品ID查询是否有相应的购物车商品信息存在
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @return boolean
     */
    @Override
    public boolean selectShoppingCarByGoodsAndUser(Integer userId, Integer goodsId) {
        List<ShoppingCar> shoppingCars = shoppingCarMapper.selectByUserIdAndGoodsId(userId,goodsId);
        if (shoppingCars.isEmpty()){
            return true;
        }
        return false;
    }


    /**
     * 增加商品数量
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param numbers 商品数量
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateGoodsNumbers(Integer userId, Integer goodsId, Integer numbers) {
        Integer originalNumbers = shoppingCarMapper.selectByNumbers(userId,goodsId);
        Integer presentNumbers = originalNumbers+numbers;
        shoppingCarMapper.updateByNumbers(userId,goodsId,presentNumbers);
    }

    /**
     * 删除购物车的某一商品信息
     * @param id 商品主键
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteShoppingCar(Integer id) {
        shoppingCarMapper.delete(id);
    }

    /**
     * 根据购物车主键查询购物车内容
     * @param id 购物车主键
     * @return 购物车对象
     */
    @Override
    public ShoppingCar selectShoppingCar(Integer id) {
        return shoppingCarMapper.selectById(id);
    }

    /**
     * 查询用户的购物车里有几件商品
     * @param userId 用户ID
     * @return 商品数量
     */
    @Override
    public Integer countShoppingCayByUser(Integer userId) {
        return shoppingCarMapper.countByUserId(userId);
    }

    /**
     * 根据关键字查询
     * @param goodsName 商品名（关键字）
     * @return 商品对象数组
     */
    @Override
    public List<Goods> searchGoodsByKeyWord(String goodsName) {
        return goodsMapper.selectByKeyWord(goodsName);
    }


}
