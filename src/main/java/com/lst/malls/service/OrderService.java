package com.lst.malls.service;

import com.lst.malls.pojo.Order;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 16:15 2019/9/16
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface OrderService {


    /**
     * 展示
     * @return
     */
    List<Order> list();


    /**
     * 更新订单
     * @param order
     */
    void update(Order order);

    /**
     *添加订单
     */
    void add(Order order);

}
