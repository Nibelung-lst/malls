package com.lst.malls.mapper;

import com.lst.malls.pojo.OrderDetail;
import com.lst.malls.pojo.OrderDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author:Nibelung
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
     * 根据条件查询订单详情
     * @param example
     * @return
     */
    List<OrderDetail> selectByExample(OrderDetailExample example);

}