package com.lst.malls.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lst.malls.pojo.Category;
import com.lst.malls.pojo.Goods;
import com.lst.malls.service.CategoryService;
import com.lst.malls.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author :Nibelung
 * @Date ：Created in 17:22 2019/9/12
 * @Description :商品controller
 */

@Controller
@RequestMapping("back")
public class GoodsController {
    /**
     * 商品service
     */
    @Autowired
    GoodsService goodsService;

    /**
     * 分类service
     */
    @Autowired
    CategoryService categoryService;

    /**
     * 指定分类下的商品展示
     * @param pageNumber
     * @param model
     * @param categoryName
     * @param session
     * @return
     */
    @RequestMapping("goodsCategoryList")
    public String listCategoryGoods(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber, Model model, String categoryName, HttpSession session){

        PageHelper.startPage(pageNumber,5);
        List<Goods> goods = goodsService.listCategory(categoryName);
        PageInfo page = new PageInfo(goods,5);
        model.addAttribute("GoodPageInfo",page);
        session.setAttribute("Category",categoryName);
        return "back/GoodsCategoryList";
    }


    /**
     * 订单显示
     * @param pageNumber
     * @param model
     * @return
     */
    @RequestMapping("goodsList")
    public String list(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber, Model model){

        PageHelper.startPage(pageNumber,5);
        List<Goods> goods = goodsService.list();
        PageInfo page = new PageInfo(goods,5);
        model.addAttribute("GoodsPageInfo",page);
        return "back/GoodsList";
    }

    /**
     * 添加商品页展示
     * @param model
     * @return
     */
    @RequestMapping("goodsAddList")
    public String goodsAddList(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("goodsAddList",categories);
        return "back/GoodsAdd";
    }

    /**
     * 分类添加，前端传参回来，在这里设置创建时间，并进行分类名重复的校验
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping("goodsAdd")
    public String addGoods(Goods goods, String name, Model model, MultipartFile file) throws IOException {
        if (goods == null)
        {
            return "static_page/Error";
        }
        //分类名校验
        boolean checking = goodsService.exist(name);
        if (!checking){
            model.addAttribute("GoodsExist",true);
            return "back/GoodsAdd";
        }
        //设置创建分类时的日期

        //图片上传成功后，将图片的地址写到数据库
        //保存图片的路径
        String filePath = "C:\\images";
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字 //uuid通用唯一识别码
        String newFileName = UUID.randomUUID()+originalFilename;
         //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);
        goods.setImage(newFileName);


        goods.setCreateDate(new Date());
        goodsService.add(goods);
        //返回参数 model 提示添加成功
        model.addAttribute("GoodsSucceed",true);
        return "back/GoodsAdd";
    }

    /**
     * 删除分类
     * @param id
     * @param pageNumber
     * @return
     */
    @RequestMapping("goodsDelete")
    public String delete(Integer id, Integer pageNumber){
        if (id == null){
            return "static_page/Error";
        }
        goodsService.delete(id);
        //删除完成后返回到先前页数下的分类展示页面
        return "redirect:/back/goodsList?pageNumber="+pageNumber;
    }

    /**
     * 展示商品修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("goodsUpdateList")
    public String goodsUpdateList(Integer id,Model model){
        Goods goods = goodsService.get(id);
        model.addAttribute("goods",goods);
        List<Category> categories = categoryService.list();
        model.addAttribute("categories",categories);
        return "back/GoodsUpdata";
    }
    /**
     * 修改分类，设置最后修改时间，分类名校验
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping("goodsUpdate")
    public String updateGoods(Goods goods, Model model, MultipartFile file) throws IOException {
        if (goods == null){
            return "static_page/Error";
        }

        /**
         * 缺少名字校验
         */
       if (!file.isEmpty()) {
           //图片上传成功后，将图片的地址写到数据库
           //保存图片的路径
           String filePath = "C:\\images";
           //获取原始图片的拓展名
           String originalFilename = file.getOriginalFilename();
           //新的文件名字
           String newFileName = UUID.randomUUID() + originalFilename;
           //封装上传文件位置的全路径
           File targetFile = new File(filePath, newFileName);
           //把本地文件上传到封装上传文件位置的全路径
           file.transferTo(targetFile);
           goods.setImage(newFileName);
       }


        //修改时间设置
        goods.setFinalChangeTime(new Date());
        goodsService.update(goods);

        model.addAttribute("CategoryUpdataSucceed",true);
        return "back/GoodsUpdata";

    }

}
