package com.lst.malls.controller;

import com.lst.malls.pojo.*;
import com.lst.malls.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 17:26 2019/9/20
 * @Description :前台页面controller
 */
@RequestMapping("fore")
@Service
public class ForePageController {
    /**
     * 分类service
     */
    @Autowired
    CategoryService categoryService;
    /**
     * 用户service
     */
    @Autowired
    UserService userService;
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
     * 前台登录
     * @param name 会员名字
     * @param password 会员密码
     * @param session 登录状态保存到session
     * @param model 验证状态
     * @return 跳转到相应页面
     */
    @RequestMapping("foreLogin")
    public String login(String name, String password, HttpSession session, Model model)  {
        //用户名或者密码为空的话，则跳转到登录错误界面
        if (name == null||password ==null){
            return "static_page/Error";
        }
        //用户名和密码错误，跳转到提示页面
        User user = userService.get(name,password);
        if (user == null){
            model.addAttribute("ForeLoginError",true);
            return "fore/ForeRegister";
        }
        if (!user.getStatus()){
            model.addAttribute("Status",true);
            return "fore/ForeRegister";
        }
        //用户名和密码正确，向前端传参，并跳转到后台管理系统页面
        session.setAttribute("user",user);
        Integer shoppingCarNumbers = foreService.countShoppingCayByUser(user.getId());
        session.setAttribute("shoppingCarNumbers",shoppingCarNumbers);
        return "fore/Fore";

    }

    /**
     * 脱出登录
     * @param session 清除session
     * @return 跳转到相应页面
     */
    @RequestMapping("foreLoginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("ForeLoginError");
        session.removeAttribute("user");
        return "fore/Fore";
    }

    /**
     * 注册
     * @param user 前台传递回来的会员实体类
     * @param model 向前台传递注册成功的信息
     * @param name 前台传递回来的会员名用于查重
     * @param sexCheck 前台传递回来的会员性别
     * @return 跳转到相应页面
     */
    @RequestMapping("foreRegister")
    public String register(User user, Model model, String name, String sexCheck){
        System.out.println(sexCheck);
        String a = "1",b = "0";
        if (user == null){
            return "static_page/Error";
        }
        boolean exist =  userService.exist(name);
        if (!exist){
            model.addAttribute("UserExist",true);
            return "fore/ForeRegister";
        }
        if (a.equals(sexCheck)){
            user.setSex(true);
        }
        if (b.equals(sexCheck)){
            user.setSex(false);
        }
            user.setPoint(0);
            userService.add(user);
            model.addAttribute("RegisterSucceed", true);
            return "fore/ForeRegister";

    }

    /**
     * 获取分类返回到商城主页面
     * @param session 将所有分类存到session
     * @return 跳转到相应页面
     */
    @RequestMapping("foreCategoryList")
    public String categoryList(HttpSession session){
        List<Category> categories = categoryService.list();
        session.setAttribute("ForeCategory",categories);
        return "fore/Fore";
    }

    /**
     * 搜索框
     * @param keyWord 前台搜索框传递回来的关键字段
     * @param model 向前台传递参数
     * @return 跳转到相应页面
     */
    @RequestMapping("searchBox")
    public String searchBox(String keyWord,Model model){
        List<Goods> goods = foreService.searchGoodsByKeyWord(keyWord);
        model.addAttribute("CategoryGood",goods);
        return "fore/CategoryGoods";
    }

}
