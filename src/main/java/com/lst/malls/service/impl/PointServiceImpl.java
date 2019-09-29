package com.lst.malls.service.impl;

import com.lst.malls.mapper.PointMapper;
import com.lst.malls.mapper.UserMapper;
import com.lst.malls.pojo.Point;
import com.lst.malls.pojo.PointExample;
import com.lst.malls.pojo.User;
import com.lst.malls.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PointExample example = new PointExample();
        List<Point> points = pointMapper.selectByExample(example);
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
        User user = userMapper.selectById(point.getUser_id());
        point.setUser(user);
    }
    }
