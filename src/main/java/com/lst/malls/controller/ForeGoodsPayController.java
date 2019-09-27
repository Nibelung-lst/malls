package com.lst.malls.controller;

import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.Order;
import com.lst.malls.pojo.OrderDetail;
import com.lst.malls.pojo.User;
import com.lst.malls.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
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
public class ForeGoodsPayController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    ForeService foreService;

    /**
     * 前台通过分类显示相应的商品
     * @param categoryName
     * @param model
     * @return
     */
    @RequestMapping("categoryGoods")
    public String categoryGoods(String categoryName, Model model){

        List<Goods> goods = goodsService.listCategory(categoryName);
        model.addAttribute("CategoryGood",goods);
        return "fore/CategoryGoods";
    }

    /**
     * 通过商品名字找到相应的商品
     * @param goodsName
     * @param model
     * @return
     */
    @RequestMapping("Goods")
    public String foreGoods(String goodsName, Model model){
        Goods goods = goodsService.getByName(goodsName);
        model.addAttribute("commodity",goods);
        return "fore/GoodDetail";
    }

    /**
     *立即购买
     * @param id
     * @param goodsNumbers
     * @param model
     * @return
     */
    @RequestMapping("puyNow")
    public String puyNow(Integer id, Integer goodsNumbers, HttpSession session, Model model){
        List<OrderDetail> orderDetails = new ArrayList<>();
        //存入相应的订单详情
        Goods goods = goodsService.get(id);
        OrderDetail orderDetail = foreService.puyNow(id, goodsNumbers,goods);
        orderDetails.add(orderDetail);
        //计算订单总额
        BigDecimal price = goods.getReal_price().multiply(BigDecimal.valueOf(goodsNumbers));

        session.setAttribute("order",orderDetails);
        model.addAttribute("price",price);

        return "fore/GoodPay";
    }

    /**
     * 购物车添加
     * @param goodsId
     * @param goodsNumbers
     * @param session
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("shoppingCarAdd")
    public String shoppingCarAdd(Integer goodsId,Integer goodsNumbers,HttpSession session) throws UnsupportedEncodingException {
        Goods goods = goodsService.get(goodsId);
        OrderDetail orderDetail =foreService.puyNow(goodsId,goodsNumbers,goods);

        if (session.getAttribute("shoppingCar") == null){
            List<OrderDetail> orderDetails = new ArrayList<>();
            orderDetails.add(orderDetail);
            session.setAttribute("shoppingCar",orderDetails);
        }
        else {
            List<OrderDetail> orderDetails = (List<OrderDetail>)session.getAttribute("shoppingCar");
            for (OrderDetail orderDetail1:orderDetails){
                if (orderDetail.getGoods_id().equals(orderDetail1.getGoods_id())){
                    orderDetail1.setNumber(orderDetail1.getNumber()+orderDetail.getNumber());
                    return "redirect:/fore/Goods?goodsName="+ URLEncoder.encode(goods.getName(),"UTF-8");
                }
            }
            orderDetails.add(orderDetail);
            session.setAttribute("shoppingCar",orderDetails);
        }
        return "redirect:/fore/Goods?goodsName="+ URLEncoder.encode(goods.getName(),"UTF-8");
    }

    /**
     * 创建订单
     * @param session
     * @param order
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
        return "fore/PayConfirm";
    }

}
