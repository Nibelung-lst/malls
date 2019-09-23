package com.lst.malls.controller;

import com.lst.malls.pojo.Goods;
import com.lst.malls.service.CategoryService;
import com.lst.malls.service.GoodsService;
import com.lst.malls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class CategoryGoodsController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @Autowired
    GoodsService goodsService;

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
}
