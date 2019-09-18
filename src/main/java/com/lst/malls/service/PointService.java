package com.lst.malls.service;

import com.lst.malls.pojo.Point;

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

    void search(List<Point> points);

    void search(Point point);
}
