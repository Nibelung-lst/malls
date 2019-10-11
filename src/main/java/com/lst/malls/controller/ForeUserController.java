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
     * @param session 读取session里的用户登录状态
     * @param model 向后台传递参数
     * @return 跳转到相应页面
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
     * 显示相应状态的订单
     * @param session 读取用户登录状态
     * @param model 向前台返回查询到的相应的状态的订单信息
     * @param status 前台传递回来的状态
     * @return 跳转到相应页面
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
     * @param orderId 前台传递回来的订单编号
     * @param session 刷新会员session更新会员的积分
     * @param model 向前台传递信息
     * @return 跳转到相应页面
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
     * @param orderId 前台传递回来的订单编号
     * @param session 读取session里的登录状态
     * @return 跳转到相应页面
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
     * @param session 读取登录状态
     * @return 跳转到相应页面
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
     * @param session 读取登录状态
     * @return 跳转到相应页面
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
     * 显示积分流水
     * @param session 读取登录状态
     * @param model 向前台传参
     * @return 跳转到相应页面
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
     * @param user 前台传递回来的会员实体类
     * @param session 刷新session里保存的信息
     * @return 跳转到相应页面
     */
    @RequestMapping("myInformationChange")
    public String myInformationChange(User user,HttpSession session){
        userService.updateUser(user);
        User userUpdate = userService.searchUserById(user.getId());
        session.setAttribute("user",userUpdate);
        return "redirect:/fore/myInformationChangeList";
    }
}
