package com.lst.malls.service.impl;

import com.lst.malls.mapper.PointMapper;
import com.lst.malls.mapper.UserMapper;
import com.lst.malls.pojo.Point;
import com.lst.malls.pojo.User;
import com.lst.malls.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 13:30 2019/9/18
 * @Description :积分管理service
 */
@Service
public class PointServiceImpl implements PointService {
    /**
     * 积分表的sql方法
     */
    @Autowired
    PointMapper pointMapper;
    /**
     * 用户表的sql方法
     */
    @Autowired
    UserMapper userMapper;

    /**
     * 展示
     * @return 积分流水
     */
    @Override
    public List<Point> list() {
        return pointMapper.select();
        }

    /**
     * 查找积分
     * @param points 积分对象数组
     */
    @Override
    public void search(List<Point> points){
        for (Point point:points){
            search(point);
        }
    }

    /**
     * 查找积分
     * @param point 积分对象
     */
    @Override
    public void search(Point point){
        User user = userMapper.selectById(point.getUserId());
        point.setUser(user);
    }

    /**
     * 新增积分详情
     * @param price 金额
     * @param user 用户对象
     * @param orderId 订单编号
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addPoint(Integer price,User user,Long orderId) {
        Point point = new Point();
        point.setUserId(user.getId());
        point.setCreateTime(new Date());
        point.setOrderId(orderId);
        point.setUser(user);
        point.setPoint(price);
        Integer totalPoint = price+user.getPoint();
        point.setTotalPoint(totalPoint);
        userMapper.updateByPoint(totalPoint,user.getId());
        pointMapper.insert(point);
    }

    /**
     * 根据用户id查询积分详情
     * @param userId 用户ID
     * @return 积分详情
     */
    @Override
    public List<Point> searchPointsByUserId(Integer userId) {
        List<Point> points = pointMapper.selectByUserId(userId);
        return points;
    }
}
