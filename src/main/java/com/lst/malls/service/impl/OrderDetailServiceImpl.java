package com.lst.malls.service.impl;

import com.lst.malls.mapper.OrderDetailMapper;
import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderDetail;
import com.lst.malls.pojo.OrderDetailExample;
import com.lst.malls.service.GoodsService;
import com.lst.malls.service.OrderDetailService;
import com.lst.malls.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @Author :Nibelung
 * @Date ：Created in 10:12 2019/9/17
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;


    @Override
    /**遍历每个订单然后将每个订单对象传入到fill对象里。*/
    public void searchOrderDetail(List<Order> orders) {
        for (Order order : orders){
            searchOrderDetail(order);
        }

    }

    /**传入一个订单对象找出符合的商品*/
    @Override
    public void searchOrderDetail(Order order) {
        OrderDetailExample example = new OrderDetailExample();
        //通过传进来的订单对象里的订单id到订单详情里找id，select * from orderDetail where order.id = order_id
        example.createCriteria().andOrder_idEqualTo(order.getId());
        List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(example);

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
            price = price.add(number.multiply(orderDetail.getGoods().getReal_price()));

        }

        //保存price到order表里的总金额
        order.setPrice(price);

        //将金额更新到数据库里
        orderService.update(order);

        order.setOrderDetails(orderDetails);

    }

    /**遍历每张订单详情表**/
    public void searchGoods(List<OrderDetail> orderDetails){
        for (OrderDetail orderDetail:orderDetails){
            searchGoods(orderDetail);
        }
    }
    /**将每一张订单详情表通过商品id查出相应的商品信息*/
    private void searchGoods(OrderDetail orderDetail){
        //通过主键进行查询
        Goods goods = goodsService.get(orderDetail.getGoods_id());
        //封装到orderDetail下
        orderDetail.setGoods(goods);
    }
}
