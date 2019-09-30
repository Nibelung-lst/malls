package com.lst.malls.service;

import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderDetail;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 10:07 2019/9/17
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface OrderDetailService {

    /**
     * 查询要查询订单详情的订单
     * @param os
     */
    void  searchOrderDetail(List<Order> os);

    /**
     * 找出相应订单下的商品
     * @param o
     */
    void searchOrderDetail(Order o);


    /**
     * 添加订单详情
     * @param orderDetail
     */
    void add(OrderDetail orderDetail);

    /**
     * 根据订单编号删除订单详情
     * @param orderId
     */
    void delete(Long orderId);


}
