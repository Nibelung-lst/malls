package com.lst.malls.service.impl;

import com.lst.malls.mapper.OrderDetailMapper;
import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderDetail;
import com.lst.malls.service.GoodsService;
import com.lst.malls.service.OrderDetailService;
import com.lst.malls.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 10:12 2019/9/17
 * @Description :订单详情管理service
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    /**
     * 订单详情表的sql方法
     */
    @Autowired
    OrderDetailMapper orderDetailMapper;
    /**
     * 商品表的sql方法
     */
    @Autowired
    GoodsService goodsService;
    /**
     * 订单表的sql方法
     */
    @Autowired
    OrderService orderService;


    @Override
    /**
     * 查询要查询订单详情的订单
     * @param orders 订单对象数组
     */
    public void searchOrderDetail(List<Order> orders) {
        for (Order order : orders){
            searchOrderDetail(order);
        }

    }

    /**
     * 找出相应订单下的商品
     * @param order 订单对象
     */
    @Override
    public void searchOrderDetail(Order order) {

        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(order.getOrderId());

        //将找出来的所以订单详情orderDetails传递到setGoods方法进行下一步查询;
        searchGoods(orderDetails);

        //进行订单总金额的计算，数据库金额的格式为bigdecimal，所以采用bigdecimal的计算方式
        // price = 0
        BigDecimal price = new BigDecimal("0");
        //遍历订单详细表里的数据
        for (OrderDetail orderDetail:orderDetails){
            //int number = od.number
            BigDecimal number = new BigDecimal(Integer.toString(orderDetail.getNumber()));
            //price+=number*real_price
            price = price.add(number.multiply(orderDetail.getGoods().getRealPrice()));

        }

        //保存price到order表里的总金额
        order.setPrice(price);

        //将金额更新到数据库里
        orderService.update(order);

        order.setOrderDetails(orderDetails);

    }

    /**
     * 添加订单详情
     * @param orderDetail 订单详情对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(OrderDetail orderDetail) {
        orderDetailMapper.insert(orderDetail);

    }

    /**
     * 根据订单编号删除订单详情
     * @param orderId 订单编号
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long orderId) {
        orderDetailMapper.delete(orderId);
    }

    /**
     * 根据订单详情一个个查询商品
     * @param orderDetails 订单详情对象数组
     */
    public void searchGoods(List<OrderDetail> orderDetails){
        for (OrderDetail orderDetail:orderDetails){
            searchGoods(orderDetail);
        }
    }

    /**
     * 为每个订单详情添加商品
     * @param orderDetail 订单详情对象
     */
    private void searchGoods(OrderDetail orderDetail){
        //通过主键进行查询
        Goods goods = goodsService.get(orderDetail.getGoodsId());
        //封装到orderDetail下
        orderDetail.setGoods(goods);
    }
}
