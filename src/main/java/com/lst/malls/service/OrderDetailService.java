package com.lst.malls.service;

import com.lst.malls.pojo.Order;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 10:07 2019/9/17
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface OrderDetailService {

    void  searchOrderDetail(List<Order> os);

    void searchOrderDetail(Order o);
}
