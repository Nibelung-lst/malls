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
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Service
public class OrderServiceImpl implements OrderService {

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
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public List<Order> searchByName(String userName) {

        List<Order> orders = orderMapper.selectByUserName(userName);
        return orders;
    }

    @Override
    public List<Order> searchByNameAndStatus(String userName, String status) {
        List<Order> orders = orderMapper.selectByUserIdAndStatus(userName,status);
        return orders;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void changeStatus(Long orderId, String status) {
        orderMapper.updateStatusByOrderId(status,orderId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateFinishTime(Long orderId, Date finishTime) {
        orderMapper.updateFinishTimeByOrderId(finishTime,orderId);
    }

    @Override
    public Order searchByOrderId(Long orderId) {
        Order order =orderMapper.selectByOrderId(orderId);
        return order;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long orderId) {
        orderMapper.delete(orderId);
    }


}
