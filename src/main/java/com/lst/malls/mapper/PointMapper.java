package com.lst.malls.mapper;

import com.lst.malls.pojo.Point;
import com.lst.malls.pojo.PointExample;
import java.util.List;

public interface PointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Point record);

    int insertSelective(Point record);

    List<Point> selectByExample(PointExample example);

    Point selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKey(Point record);
}