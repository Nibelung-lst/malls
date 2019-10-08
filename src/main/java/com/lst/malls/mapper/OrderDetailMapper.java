package com.lst.malls.mapper;

import com.lst.malls.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 订单详情mapper
 */
public interface OrderDetailMapper {
    /**
     * 根据主键删除订单详情
     * @param orderId
     * @return
     */
    Integer delete(@Param("orderId") Long orderId);

    /**
     * 新增订单详情
     * @param record
     * @return
     */
    Integer insert(OrderDetail record);
    /**
     * 根据订单ID查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetail> selectByOrderId(@Param("order_id") Long orderId);


}