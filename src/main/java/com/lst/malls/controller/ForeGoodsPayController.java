package com.lst.malls.controller;

import com.lst.malls.pojo.*;
import com.lst.malls.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author :Nibelung
 * @Date ：Created in 14:19 2019/9/23
 * @Description :前台商品购买controller
 */
@RequestMapping("fore")
@Controller
public class ForeGoodsPayController {

    /**
     * 分类service
     */
    @Autowired
    CategoryService categoryService;

    /**
     * 商品service
     */
    @Autowired
    GoodsService goodsService;

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
     * 前台service
     */
    @Autowired
    ForeService foreService;


    /**
     * 前台通过分类显示相应的商品
     * @param categoryName 前台传递分类名查询相应的商品
     * @param model 向前台传递数据
     * @return 跳转到相应页面
     */
    @RequestMapping("categoryGoods")
    public String categoryGoods(String categoryName, Model model){

        List<Goods> goods = goodsService.listCategory(categoryName);
        model.addAttribute("CategoryGood",goods);
        return "fore/CategoryGoods";
    }

    /**
     * 通过商品名字找到相应的商品
     * @param goodsName 前台传递商品名查询相应的商品详情
     * @param model 向前台传递数据
     * @return 跳转到相应页面
     */
    @RequestMapping("Goods")
    public String foreGoods(String goodsName, Model model){
        Goods goods = goodsService.getByName(goodsName);
        model.addAttribute("commodity",goods);
        return "fore/GoodDetail";
    }

    /**
     * 提交购物车生成订单
     * @param shoppingCarId 前台传递的购物车主键
     * @param session 刷新主页购物车的商品数量
     * @param model 向前台传递数据
     * @return 跳转到相应页面
     */
    @RequestMapping("shoppingCarPuy")
    public String shoppingCarPuy(String []shoppingCarId,HttpSession session,Model model){
        List<OrderDetail> orderDetails =new ArrayList<>();
        BigDecimal price = new BigDecimal("0.00");
        for (String s : shoppingCarId){
            int id = Integer.parseInt(s);
            ShoppingCar shoppingCar = foreService.selectShoppingCar(id);
            Goods goods = goodsService.get(shoppingCar.getGoodsId());
            OrderDetail orderDetail = foreService.puyNow(shoppingCar.getGoodsId(),shoppingCar.getNumbers(),goods);
            price = price.add(goods.getRealPrice().multiply(BigDecimal.valueOf(orderDetail.getNumber())));
            orderDetails.add(orderDetail);
            foreService.deleteShoppingCar(id);
        }
        User user = (User)session.getAttribute("user");
        Integer shoppingCarNumbers = foreService.countShoppingCayByUser(user.getId());
        session.setAttribute("shoppingCarNumbers",shoppingCarNumbers);
        session.setAttribute("order",orderDetails);
        model.addAttribute("price",price);
        return "fore/GoodPay";
    }

    /**
     *立即购买
     * @param id 商品id
     * @param goodsNumbers 商品数量
     * @param model 传参
     * @return 跳转到相应页面
     */
    @RequestMapping("puyNow")
    public String puyNow(Integer id, Integer goodsNumbers, HttpSession session, Model model){
        List<OrderDetail> orderDetails = new ArrayList<>();
        //存入相应的订单详情
        Goods goods = goodsService.get(id);
        OrderDetail orderDetail = foreService.puyNow(id, goodsNumbers,goods);
        orderDetails.add(orderDetail);
        //计算订单总额
        BigDecimal price = goods.getRealPrice().multiply(BigDecimal.valueOf(goodsNumbers));

        session.setAttribute("order",orderDetails);
        model.addAttribute("price",price);

        return "fore/GoodPay";
    }

    /**
     * 购物车添加
     * @param goodsId 商品id
     * @param userId 用户id
     * @param numbers 商品数量
     * @param session 保存到session
     * @return 跳转到相应页面
     * @throws UnsupportedEncodingException 重定向中文异常
     */
    @RequestMapping("shoppingCarAdd")
    public String shoppingCarAdd(Integer goodsId,Integer userId,Integer numbers,HttpSession session) throws UnsupportedEncodingException {
        Goods goods = goodsService.get(goodsId);

        if (userId == null){
            return "fore/ForeRegister";
        }
        boolean carCheck = foreService.selectShoppingCarByGoodsAndUser(userId,goodsId);
        if (carCheck){
            foreService.shoppingCarAdd(userId,goodsId,numbers);

            Integer shoppingCarNumbers = foreService.countShoppingCayByUser(userId);
            session.setAttribute("shoppingCarNumbers",shoppingCarNumbers);
            return "redirect:/fore/Goods?goodsName="+ URLEncoder.encode(goods.getName(),"UTF-8");
        }
        Integer shoppingCarNumbers = foreService.countShoppingCayByUser(userId);
        session.setAttribute("shoppingCarNumbers",shoppingCarNumbers);
        foreService.updateGoodsNumbers(userId,goodsId,numbers);
        return "redirect:/fore/Goods?goodsName="+URLEncoder.encode(goods.getName(),"UTF-8");
    }

    /**
     *购物车展示
     * @param userId 用户ID
     * @param model 传参
     * @return
     */
    @RequestMapping("shoppingCarShow")
    public String shoppingCarShow(Integer userId,Model model){
        if (userId == null){
            return "fore/ForeRegister";
        }
        List<ShoppingCar> shoppingCars = foreService.selectShoppingByUserId(userId);
        for (ShoppingCar shoppingCar:shoppingCars){
            shoppingCar.setGoods(goodsService.get(shoppingCar.getGoodsId()));
        }
        model.addAttribute("shoppingCars",shoppingCars);
        return "fore/ShoppingCar";
    }

    /**
     * 删除某一购物车
     * @param shoppingCarId 购物车id
     * @param session 刷新session
     * @return
     */
    @RequestMapping("deleteShoppingCar")
    @ResponseBody
    public String deleteShoppingCar(Integer shoppingCarId,HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user == null){
            return "fail";
        }
        foreService.deleteShoppingCar(shoppingCarId);
        Integer shoppingCarNumbers = foreService.countShoppingCayByUser(user.getId());
        session.setAttribute("shoppingCarNumbers",shoppingCarNumbers);
        return "success";
    }

    /**
     * 创建订单
     * @param session 读取订单详情的session
     * @param order 前台传递回来的订单实体类
     * @return
     */
    @RequestMapping("creatOrder")
    public String creatOrder(HttpSession session,Order order,Model model){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }
        List<OrderDetail> orderDetails =(List<OrderDetail>)session.getAttribute("order");
        Order order1 = foreService.creatOrder(order,orderDetails,user);
        orderService.add(order1);
        model.addAttribute("order1",order1);
        return "fore/GoodsPayOff";
    }

    /**
     * 支付页面展示
     * @param orderId 支付的订单id
     * @param model 保存到model返回给前台
     * @return
     */
    @RequestMapping("paySucceedShow")
    public String paySucceedShow(Long orderId,Model model){
        Order order = orderService.searchByOrderId(orderId);
        model.addAttribute("order1",order);
        return "fore/GoodsPayOff";
    }
    /**
     * 商品支付
     * @param orderId 支付的订单id
     * @param model 保存到model返回给前台
     * @return
     */
    @RequestMapping("paySucceed")
    public String paySucceed(Long orderId,Model model){
        String status = "待收货";
        orderService.changeStatus(orderId,status);
        Order order = orderService.searchByOrderId(orderId);
        model.addAttribute("order1",order);
        return "fore/PayConfirm";
    }

}
