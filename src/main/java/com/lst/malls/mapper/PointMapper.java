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
     * @return 积分对象数组
     */
    List<Point> select();
    /**
     * 插入
     * @param point 积分对象
     * @return 插入成功
     */
    Integer insert(Point point);

    /**
     * 根据ID查询积分
     * @param userId 用户主键
     * @return 积分对象数组
     */
    List<Point> selectByUserId(@Param("user_id") Integer userId);


}