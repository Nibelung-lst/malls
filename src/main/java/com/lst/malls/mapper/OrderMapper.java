package com.lst.malls.mapper;

import com.lst.malls.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 订单mapper
 */
public interface OrderMapper {

    /**
     * 查询所有订单
     * @return 订单对象数组
     */
    List<Order> select();

    /**
     * 根据用户名查询订单信息
     * @param userName 用户名
     * @return 订单对象数组
     */
    List<Order> selectByUserName(@Param("userName") String userName);
    /**
     * 根据主键删除订单
     * @param orderId 订单编号
     * @return 删除成功
     */
    Integer delete(@Param("orderId") Long orderId);

    /**
     * 新增订单信息
     * @param record 订单对象
     * @return 新增成功
     */
    Integer insert(Order record);


    /**
     * 更新订单详情
     * @param record 订单对象
     * @return 更新成功
     */
    Integer update(Order record);

    /**
     * 根据用户和状态查询相应的订单信息
     * @param userName 用户名
     * @param status 订单状态
     * @return 订单对象数组
     */
    List<Order> selectByUserIdAndStatus(@Param("user_name") String userName, @Param("status") String status);

    /**
     * 根据订单编号修改订单状态
     * @param status 订单状态
     * @param orderId 订单编号
     * @return 修改成功
     */
    Integer updateStatusByOrderId(@Param("status")String status, @Param("order_ID")Long orderId);

    /**
     * 根据订单编号修改完成时间
     * @param finishTime 订单完成时间
     * @param orderId 订单编号
     * @return 修改成功
     */
    Integer updateFinishTimeByOrderId(@Param("finish_time")Date finishTime,@Param("order_ID")Long orderId);

    /**
     * 根据订单编号查询订单
     * @param orderId 订单编号
     * @return 订单对象
     */
    Order selectByOrderId(@Param("Order_ID")Long orderId);
}