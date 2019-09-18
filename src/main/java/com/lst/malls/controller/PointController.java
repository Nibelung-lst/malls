package com.lst.malls.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lst.malls.pojo.Point;
import com.lst.malls.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author :Nibelung
 * @Date ：Created in 13:31 2019/9/18
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Controller
@RequestMapping("back")
public class PointController {
    @Autowired
    PointService pointService;
    @RequestMapping("point_list")
    public String List(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){


        //设置起始页，每页展示5条数据
        PageHelper.startPage(pn,5);
        //将user表下的数据传入到users数组里
        java.util.List<Point> points = pointService.list();

        pointService.search(points);
        //使用pageInfo包装查询后的结果,只需要将pageInfo交给页面就行了
        PageInfo page = new PageInfo(points,5);
        //通过model将page传递到前台
        model.addAttribute("PointPageInfo",page);
        return "back/PointList";
    }
}
