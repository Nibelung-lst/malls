package com.lst.malls.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lst.malls.pojo.Order;
import com.lst.malls.service.OrderDetailService;
import com.lst.malls.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 16:22 2019/9/16
 * @Description :订单controller
 */
@Controller
@RequestMapping("back")
public class OrderController {

    /**
     * 订单service
     */
    @Autowired
    OrderService orderService;
    /**
     * 订单详情service
     */
    @Autowired
    OrderDetailService orderDetailService;

    /**
     * 在原有分页的基础上加上订单详情的查找和显示
     * @param pageNumber 分页页数
     * @param model 向前台传参
     * @return 跳转到相应页面
     */
    @RequestMapping("orderList")
    public String list(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber, Model model){

        PageHelper.startPage(pageNumber,5);
        List<Order> orders = orderService.list();

        //查出订单详情
        orderDetailService.searchOrderDetail(orders);

        PageInfo page = new PageInfo(orders,5);


        model.addAttribute("OrderPageInfo",page);
        return "back/OrderList";
    }
}
