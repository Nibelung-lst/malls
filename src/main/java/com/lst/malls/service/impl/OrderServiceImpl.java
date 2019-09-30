package com.lst.malls.service.impl;

import com.lst.malls.mapper.OrderMapper;
import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderExample;
import com.lst.malls.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        OrderExample example = new OrderExample();

        List<Order> order = orderMapper.selectByExample(example);

        return order;
    }

    /**
     *
     * @return
     */
    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    @Override
    public void add(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public List<Order> searchByName(String userName) {
        OrderExample example = new OrderExample();
        example.createCriteria().andUser_nameEqualTo(userName);
        List<Order> orders = orderMapper.selectByExample(example);
        return orders;
    }

    @Override
    public List<Order> searchByNameAndStatus(String userName, String status) {
        List<Order> orders = orderMapper.selectByUserIdAndStatus(userName,status);
        return orders;
    }

    @Override
    public void changeStatus(Long orderId, String status) {
        orderMapper.updateStatusByOrderId(status,orderId);
    }

    @Override
    public void updateFinishTime(Long orderId, Date finishTime) {
        orderMapper.updateFinishTimeByOrderId(finishTime,orderId);
    }

    @Override
    public Order searchByOrderId(Long orderId) {
        Order order =orderMapper.selectByOrderId(orderId);
        return order;
    }

    @Override
    public void delete(Long orderId) {
        orderMapper.delete(orderId);
    }


}
