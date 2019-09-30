package com.lst.malls.mapper;

import com.lst.malls.pojo.Point;
import com.lst.malls.pojo.PointExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:Nibelung
 */
public interface PointMapper {


    /**
     * 根据条件查询积分
     * @param example
     * @return
     */
    List<Point> selectByExample(PointExample example);

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