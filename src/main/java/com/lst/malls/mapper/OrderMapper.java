package com.lst.malls.mapper;

import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderExample;
import java.util.List;

/**
 * @Author:Nibelung
 */
public interface OrderMapper {
    /**
     * 根据主键删除订单
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 新增订单信息
     * @param record
     * @return
     */
    int insert(Order record);

    /**
     * 根据条件查询订单
     * @param example
     * @return
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * 更新订单详情
     * @param record
     * @return
     */
    int update(Order record);

}