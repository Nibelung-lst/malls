package com.lst.malls.controller;

import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.Point;
import com.lst.malls.pojo.User;
import com.lst.malls.service.OrderDetailService;
import com.lst.malls.service.OrderService;
import com.lst.malls.service.PointService;
import com.lst.malls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 16:45 2019/9/29
 * @Description :前台用户界面controller
 */
@Controller
@RequestMapping("fore")
public class ForeUserController {
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
     * 积分service
     */
    @Autowired
    PointService pointService;
    /**
     * 用户service
     */
    @Autowired
    UserService userService;
    /**
     * 根据用户名查询订单信息
     * @return
     */
    @RequestMapping("orderInformation")
    public String orderInformation(HttpSession session, Model model){
        User user =(User)session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }
        List<Order> orders = orderService.searchByName(user.getName());
        orderDetailService.searchOrderDetail(orders);
        model.addAttribute("orderInformation",orders);
        return "fore/MyOrders";
    }

    /**
     *显示待收货订单
     * @param session
     * @return
     */
    @RequestMapping("orderReceived")
    public String orderReceived(HttpSession session,Model model,String status){
        String finishStatus = "已完成";
        String noPayStatus = "待付款";
        User user = (User)session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }
        List<Order> orders = orderService.searchByNameAndStatus(user.getName(),status);
        orderDetailService.searchOrderDetail(orders);
        model.addAttribute("orderInformation",orders);
        if (status.equals(finishStatus)){
            return "fore/MyFinishOrder";
        }
        else if (status.equals(noPayStatus)){
            return "fore/MyOrderNoPayOff";
        }
        return "fore/MyOrderNoReceived";
    }

    /**
     * 确认收货
     * @param orderId
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("received")
    public String received(Long orderId,HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }
        String status="已完成";
        Order order = orderService.searchByOrderId(orderId);
        Integer price = order.getPrice().intValue();
        pointService.addPoint(price,user,orderId);
        orderService.changeStatus(orderId,status);
        orderService.updateFinishTime(orderId,new Date());
        model.addAttribute("order2",order);
        //刷新session
        User userUpdate = userService.searchUserById(user.getId());
        session.setAttribute("user",userUpdate);
        return "fore/ReceivedConfirm";
    }

    /**
     * 删除订单
     * @param orderId
     * @param session
     * @return
     */
    @RequestMapping("deleteOrder")
    public String deleteOrder(Long orderId,HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }
        orderDetailService.delete(orderId);
        orderService.delete(orderId);
        return "redirect:/fore/orderInformation";
    }

    /**
     * 显示个人信息
     * @param session
     * @return
     */
    @RequestMapping("myInformation")
    public String myInformation(HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }
        return "fore/MyInformation";
    }
    /**
     * 显示个人信息的修改页面
     * @param session
     * @return
     */
    @RequestMapping("myInformationChangeList")
    public String myInformationChangeList(HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }
        return "fore/MyInformationChange";
    }

    /**
     * 显示积分详情
     * @return
     */
    @RequestMapping("myPointDetail")
    public String myPointDetail(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }
        List<Point> points = pointService.searchPointsByUserId(user.getId());
        model.addAttribute("points",points);
        return "fore/MyPointDetail";
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @RequestMapping("myInformationChange")
    public String myInformationChange(User user,HttpSession session){
        userService.updateUser(user);
        User userUpdate = userService.searchUserById(user.getId());
        session.setAttribute("user",userUpdate);
        return "redirect:/fore/myInformationChangeList";
    }
}
