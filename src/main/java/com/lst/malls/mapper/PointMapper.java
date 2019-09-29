package com.lst.malls.mapper;

import com.lst.malls.pojo.Point;
import com.lst.malls.pojo.PointExample;
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


}