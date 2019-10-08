package com.lst.malls.service.impl;

import com.lst.malls.mapper.OrderMapper;
import com.lst.malls.pojo.Order;
import com.lst.malls.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 16:17 2019/9/16
 * @Description :订单管理与显示service
 */
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 订单表的sql方法
     */
    @Autowired
    OrderMapper orderMapper;
    /**
     * 查询Order表里的账户数据
     *
     * @return admin
     */
    @Override
    public List<Order> list() {


        List<Order> order = orderMapper.select();

        return order;
    }

    /**
     * 更新订单
     * @param order
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    /**
     * 添加订单
     * @param order
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Order order) {
        orderMapper.insert(order);
    }

    /**
     * 根据用户名查询订单
     * @param userName
     * @return
     */
    @Override
    public List<Order> searchByName(String userName) {

        List<Order> orders = orderMapper.selectByUserName(userName);
        return orders;
    }

    /**
     *通过状态和用户名查询订单
     * @param userName
     * @param status
     * @return
     */
    @Override
    public List<Order> searchByNameAndStatus(String userName, String status) {
        List<Order> orders = orderMapper.selectByUserIdAndStatus(userName,status);
        return orders;
    }

    /**
     * 改变订单状态
     * @param orderId
     * @param status
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void changeStatus(Long orderId, String status) {
        orderMapper.updateStatusByOrderId(status,orderId);
    }

    /**
     * 更新订单完成时间
     * @param orderId
     * @param finishTime
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateFinishTime(Long orderId, Date finishTime) {
        orderMapper.updateFinishTimeByOrderId(finishTime,orderId);
    }

    /**
     * 根据订单编号查询订单
     * @param orderId
     * @return
     */
    @Override
    public Order searchByOrderId(Long orderId) {
        Order order =orderMapper.selectByOrderId(orderId);
        return order;
    }

    /**
     * 根据订单编号删除订单
     * @param orderId
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long orderId) {
        orderMapper.delete(orderId);
    }


}
