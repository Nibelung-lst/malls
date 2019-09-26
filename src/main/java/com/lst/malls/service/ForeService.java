package com.lst.malls.service;

import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderDetail;
import com.lst.malls.pojo.User;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 10:44 2019/9/26
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface ForeService {


    OrderDetail puyNow(Integer id, Integer num, Goods goods);

    Order creatOrder(Order order,List<OrderDetail> orderDetails, User user);

}
