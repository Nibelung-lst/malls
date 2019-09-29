package com.lst.malls.mapper;

import com.lst.malls.pojo.OrderDetail;
import com.lst.malls.pojo.OrderDetailExample;
import java.util.List;
/**
 * @Author:Nibelung
 */
public interface OrderDetailMapper {
    /**
     * 根据主键删除订单详情
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 新增订单详情
     * @param record
     * @return
     */
    int insert(OrderDetail record);

    /**
     * 根据条件查询订单详情
     * @param example
     * @return
     */
    List<OrderDetail> selectByExample(OrderDetailExample example);

}