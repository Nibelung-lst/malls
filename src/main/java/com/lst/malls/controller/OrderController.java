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
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Controller
@RequestMapping("back")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;

    /**在原有分页的基础上加上订单详情的查找和显示*/
    @RequestMapping("Order_list")
    public String List(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

        PageHelper.startPage(pn,5);
        List<Order> orders = orderService.list();

        //查出订单详情
        orderDetailService.searchOrderDetail(orders);

        PageInfo page = new PageInfo(orders,5);


        model.addAttribute("OrderPageInfo",page);
        return "back/OrderList";
    }
}