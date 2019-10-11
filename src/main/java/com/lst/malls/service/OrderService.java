package com.lst.malls.service;

import com.lst.malls.pojo.Order;

import java.util.Date;
import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 16:15 2019/9/16
 * @Description :订单Service
 */
public interface OrderService {


    /**
     * 展示
     * @return 订单对象数组
     */
    List<Order> list();


    /**
     * 更新订单
     * @param order 订单对象
     */
    void update(Order order);

    /**
     * 添加订单
     * @param order 订单对象
     */
    void add(Order order);

    /**
     * 根据用户名查询订单
     * @param userName 用户名
     * @return 订单对象数组
     */
    List<Order> searchByName(String userName);

    /**
     *通过状态和用户名查询订单
     * @param userName 用户名
     * @param status 状态
     * @return 订单对象数组
     */
    List<Order> searchByNameAndStatus(String userName,String status);

    /**
     * 改变订单状态
     * @param orderId 订单编号
     * @param status 订单状态
     */
    void changeStatus(Long orderId,String status);

    /**
     * 更新订单完成时间
     * @param orderId 订单编号
     * @param finishTime 完成时间
     */
    void updateFinishTime(Long orderId, Date finishTime);

    /**
     * 根据订单编号查询订单
     * @param orderId 订单编号
     * @return 订单对象
     */
    Order searchByOrderId(Long orderId);

    /**
     * 根据订单编号删除订单
     * @param orderId 订单编号
     */
    void delete(Long orderId);
}
