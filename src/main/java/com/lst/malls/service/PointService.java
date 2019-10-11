package com.lst.malls.service;

import com.lst.malls.pojo.Point;
import com.lst.malls.pojo.User;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 13:30 2019/9/18
 * @Description :积分Service
 */
public interface PointService {

    /**
     * 展示
     * @return 积分对象数组
     */
    List<Point> list();

    /**
     * 查找积分
     * @param points 积分对象数组
     */
    void search(List<Point> points);

    /**
     * 查找积分
     * @param point 积分对象
     */
    void search(Point point);


    /**
     * 新增积分详情
     * @param price 金额
     * @param user 用户对象
     * @param orderId 订单编号
     */
    void addPoint(Integer price, User user, Long orderId);

    /**
     * 根据用户id查询积分详情
     * @param userId 用户ID
     * @return
     */
    List<Point> searchPointsByUserId(Integer userId);
}
