package com.lst.malls.controller;

import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderDetail;
import com.lst.malls.pojo.User;
import com.lst.malls.service.CategoryService;
import com.lst.malls.service.GoodsService;
import com.lst.malls.service.OrderDetailService;
import com.lst.malls.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author :Nibelung
 * @Date ：Created in 14:19 2019/9/23
 * @Description :
 * @Modified By :
 * @Version : $
 */
@RequestMapping("fore")
@Controller
public class GoodsPayController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    /**
     * 前台通过分类显示相应的商品
     * @param categoryName
     * @param model
     * @return
     */
    @RequestMapping("CategoryGoods")
    public String categoryGoods(String categoryName, Model model){

        List<Goods> goods = goodsService.listCategory(categoryName);
        model.addAttribute("CategoryGood",goods);
        return "fore/CategoryGoods";
    }

    /**
     * 通过商品名字找到相应的商品
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("Goods")
    public String foreGoods(String name,Model model){
        Goods goods = goodsService.getByName(name);
        model.addAttribute("commodity",goods);
        return "fore/GoodDetail";
    }



    /**
     *立即购买
     * @param id
     * @param num
     * @param model
     * @return
     */
    @RequestMapping("PuyNow")
    public String puyNow(Integer id,Integer num,HttpSession session,Model model){
        List<OrderDetail> orderDetails = new ArrayList<>();

        //存入相应的订单详情
        Goods goods = goodsService.get(id);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setNumber(num);
        orderDetail.setGoods_id(id);
        orderDetail.setGoods(goods);

        orderDetails.add(orderDetail);

        //计算订单总额
        BigDecimal price = goods.getReal_price().multiply(BigDecimal.valueOf(num));


        session.setAttribute("order",orderDetails);
        model.addAttribute("price",price);

        return "fore/GoodPay";
    }

    @RequestMapping("shoppingCar")
    public String shoopingCar(){
        return "static_page/Error";
    }

    @RequestMapping("balance")
    public String balance(){
        return "static_page/Error";
    }


    /**
     * 创建订单
     * @param session
     * @param order
     * @return
     */
    @RequestMapping("creatOrder")
    public String creatOrder(HttpSession session,Order order){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "fore/ForeRegister";
        }

        //生成订单号
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String timeStr = sdf.format(new Date());
        // 17位时间+用户id
        Long i = Long.valueOf(timeStr + user.getId());

        List<OrderDetail> orderDetails =(List<OrderDetail>)session.getAttribute("order");
        order.setOrderDetails(orderDetails);

        for (OrderDetail o:orderDetails) {
            o.setOrder_id(i);
            orderDetailService.add(o);
        }
 
        //将订单ID和创建时间存入到订单中
        order.setOrder_ID(i);
        order.setCreator_time(new Date());
        orderService.add(order);

        return "fore/PayConfirm";
    }



}
