package com.lst.malls.service;

import com.lst.malls.pojo.Order;

import java.util.Date;
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
     * 添加订单
     * @param order
     */
    void add(Order order);

    /**
     * 根据用户名查询订单
     * @param userName
     * @return
     */
    List<Order> searchByName(String userName);

    /**
     *通过状态和用户名查询订单
     * @param userName
     * @param status
     * @return
     */
    List<Order> searchByNameAndStatus(String userName,String status);

    /**
     * 改变订单状态
     * @param orderId
     * @param status
     */
    void changeStatus(Long orderId,String status);

    /**
     * 更新订单完成时间
     * @param orderId
     * @param finishTime
     */
    void updateFinishTime(Long orderId, Date finishTime);

    /**
     * 根据订单编号查询订单
     * @param orderId
     * @return
     */
    Order searchByOrderId(Long orderId);

    /**
     * 根据订单编号删除订单
     * @param orderId
     */
    void delete(Long orderId);
}
