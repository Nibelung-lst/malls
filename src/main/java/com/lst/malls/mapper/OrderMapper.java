package com.lst.malls.mapper;

import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author:Nibelung
 */
public interface OrderMapper {
    /**
     * 根据主键删除订单
     * @param orderId
     * @return
     */
    Integer delete(@Param("orderId") Long orderId);

    /**
     * 新增订单信息
     * @param record
     * @return
     */
    Integer insert(Order record);

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
    Integer update(Order record);

    /**
     * 根据用户和状态查询相应的订单信息
     * @param userName
     * @param status
     * @return
     */
    List<Order> selectByUserIdAndStatus(@Param("user_name") String userName, @Param("status") String status);

    /**
     * 根据订单编号修改订单状态
     * @param status
     * @param orderId
     * @return
     */
    Integer updateStatusByOrder_Id(@Param("status")String status,@Param("order_ID")Long orderId);

    /**
     * 根据订单编号修改完成时间
     * @param finishTime
     * @param orderId
     * @return
     */
    Integer updateFinishTimeByOrderId(@Param("finish_time")Date finishTime,@Param("order_ID")Long orderId);

    /**
     * 根据订单编号查询订单
     * @param orderId
     * @return
     */
    Order selectByOrderId(@Param("Order_ID")Long orderId);
}