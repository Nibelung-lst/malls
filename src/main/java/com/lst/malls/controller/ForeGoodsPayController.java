package com.lst.malls.controller;

import com.lst.malls.pojo.*;
import com.lst.malls.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
     * 提交购物车生成订单
     * @param shoppingCarId
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("shoppingCarPuy")
    public String shoppingCarPuy(String []shoppingCarId,HttpSession session,Model model){
        List<OrderDetail> orderDetails =new ArrayList<>();
        BigDecimal price = new BigDecimal("0.00");
        for (String s : shoppingCarId){
            int id = Integer.parseInt(s);
            ShoppingCar shoppingCar = foreService.selectShoppingCar(id);
            Goods goods = goodsService.get(shoppingCar.getGoods_id());
            OrderDetail orderDetail = foreService.puyNow(shoppingCar.getGoods_id(),shoppingCar.getNumbers(),goods);
            price = price.add(goods.getReal_price().multiply(BigDecimal.valueOf(orderDetail.getNumber())));
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
     * @param
     *
     * @return
     */
    @RequestMapping("shoppingCarAdd")
    public String shoppingCarAdd(Integer goodsId,Integer userId,Integer numbers,HttpSession session) {

        if (userId == null){
            return "fore/ForeRegister";
        }
        boolean carCheck = foreService.selectShoppingCarByGoodsAndUser(userId,goodsId);
        if (carCheck){
            foreService.shoppingCarAdd(userId,goodsId,numbers);

            Integer shoppingCarNumbers = foreService.countShoppingCayByUser(userId);
            session.setAttribute("shoppingCarNumbers",shoppingCarNumbers);
            return "/fore/Fore";
        }
        Integer shoppingCarNumbers = foreService.countShoppingCayByUser(userId);
        session.setAttribute("shoppingCarNumbers",shoppingCarNumbers);
        foreService.updateGoodsNumbers(userId,goodsId,numbers);
        return "/fore/Fore";
    }

    /**
     *购物车展示
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("shoppingCarShow")
    public String shoppingCarShow(Integer userId,Model model){
        if (userId == null){
            return "fore/ForeRegister";
        }
        List<ShoppingCar> shoppingCars = foreService.selectShoppingByUserId(userId);
        for (ShoppingCar shoppingCar:shoppingCars){
            shoppingCar.setGoods(goodsService.get(shoppingCar.getGoods_id()));
        }
        model.addAttribute("shoppingCars",shoppingCars);
        return "fore/ShoppingCar";
    }

    /**
     * 删除某一购物车
     * @param shoppingCarId
     * @param session
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
