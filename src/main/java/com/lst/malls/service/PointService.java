package com.lst.malls.service;

import com.lst.malls.pojo.Point;
import com.lst.malls.pojo.User;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 13:30 2019/9/18
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface PointService {

    /**
     * 展示
     * @return
     */
    List<Point> list();

    /**
     * 查找积分
     * @param points
     */
    void search(List<Point> points);

    /**
     * 查找积分
     * @param point
     */
    void search(Point point);


    /**
     * 新增积分详情
     * @param price
     * @param user
     * @param orderId
     */
    void addPoint(Integer price, User user, Long orderId);

    /**
     * 根据用户id查询积分详情
     * @param userId
     * @return
     */
    List<Point> searchPointsByUserId(Integer userId);
}
