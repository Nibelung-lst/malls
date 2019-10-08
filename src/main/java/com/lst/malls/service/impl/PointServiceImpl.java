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
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Service
public class PointServiceImpl implements PointService {
    @Autowired
    PointMapper pointMapper;
    @Autowired
    UserMapper userMapper;

    /**
     *
     * @return
     */
    @Override
    public List<Point> list() {
        List<Point> points = pointMapper.select();
        return points;
        }

    /**
     *
     * @return
     */
    @Override
    public void search(List<Point> points){
        for (Point point:points){
            search(point);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public void search(Point point){
        User user = userMapper.selectById(point.getUserId());
        point.setUser(user);
    }

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

    @Override
    public List<Point> searchPointsByUserId(Integer userId) {
        List<Point> points = pointMapper.selectByUserId(userId);
        return points;
    }
}
