package com.lst.malls.mapper;

import com.lst.malls.pojo.Point;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 积分mapper
 */
public interface PointMapper {

    /**
     * 查询出所有积分详情
     * @return
     */
    List<Point> select();
    /**
     * 插入
     * @param point
     * @return
     */
    Integer insert(Point point);

    /**
     * 根据ID查询积分
     * @param userId
     * @return
     */
    List<Point> selectByUserId(@Param("user_id") Integer userId);


}