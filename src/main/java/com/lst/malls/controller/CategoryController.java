package com.lst.malls.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lst.malls.pojo.Category;
import com.lst.malls.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @Author :Nibelung
 * @Date ：Created in 9:54 2019/9/11
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Controller
@RequestMapping("back")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    /**
     * 分页展示，方法和AdminController里的一样
     * @param pageNumber
     * @param model
     * @return
     */
    @RequestMapping("categoryList")
    public String list(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber, Model model){


         //设置起始页，每页展示5条数据
        PageHelper.startPage(pageNumber,5);
        //讲category表下的数据传入到categories数组里
        java.util.List<Category> categories = categoryService.list();
        //使用pageInfo包装查询后的结果,只需要将pageInfo交给页面就行了
        PageInfo page = new PageInfo(categories,5);
        //通过model将page传递到前台
        model.addAttribute("CategoryPageInfo",page);
        return "back/CategoryList";
    }

    /**
     * 分类添加，前端传参回来，在这里设置创建时间，并进行分类名重复的校验
     * @param category
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("categoryAdd")
    public String addCategory(Category category, String name, Model model){
        if (category == null)
        {
            return "static_page/Error";
        }
        //分类名校验
        boolean checking = categoryService.exist(name);
        if (!checking){
            model.addAttribute("CategoryExist",true);
            return "back/CategoryAdd";
        }
        //设置创建分类时的日期
        category.setCreate_time(new Date());
        categoryService.add(category);
        //返回参数 model 提示添加成功
        model.addAttribute("CategorySucceed",true);
        return "back/CategoryAdd";
    }

    /**
     * 删除分类
     * @param id
     * @param pageNumber
     * @return
     */
    @RequestMapping("categoryDelete")
    public String deleteCategory(Integer id, Integer pageNumber){
        if (id == null){
            return "static_page/Error";
        }
        categoryService.delete(id);
        //删除完成后返回到先前页数下的分类展示页面
        return "redirect:/back/categoryList?pageNumber="+ pageNumber;
    }


    /**
     * 修改分类，设置最后修改时间，分类名校验
     * @param category
     * @param pageName
     * @param model
     * @return
     */
    @RequestMapping("categoryUpdate")
    public String updateCategory(Category category, String pageName, Model model){
        if (category == null){
            return "static_page/Error";
        }

        //分类名校验
        boolean checking = categoryService.exist(pageName);
        if (!checking){
            model.addAttribute("CategoryUpdataExist",true);
            return "back/CategoryUpdata";
        }
        //修改时间设置
        category.setFinal_modification_time(new Date());
        categoryService.update(category);

        model.addAttribute("CategoryUpdataSucceed",true);
        return "back/CategoryUpdata";

    }

}
