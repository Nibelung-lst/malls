package com.lst.malls.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lst.malls.pojo.Admin;
import com.lst.malls.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 10:14 2019/9/5
 * @Description :后台管理总控制器
 */
@Controller
@RequestMapping("back")
public class AdminController {

    /**
     * 管理员service
     */
    @Autowired
    AdminService adminService;

    /**
     * 分页处理
     * @return
     */
    @RequestMapping("adminList")
    public String list(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber, Model model){

        PageHelper.startPage(pageNumber,5);
        List<Admin> admins = adminService.list();
        PageInfo page = new PageInfo(admins,5);
        model.addAttribute("pageInfo",page);
        return "back/AdminList";
    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @RequestMapping("adminDelete")
    public String deleteAdmin(Integer id){
        if (id == null){
            return "static_page/Error";
        }

        adminService.delete(id);
        return "redirect:/back/adminList";
    }

    /**
     * 添加管理员
     * @param admin
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("adminAdd")
    public String addAdmin(Admin admin, String name, Model model){
        if (null == admin)
        {
            return "static_page/Error";
        }

        boolean checking = adminService.exist(name);
        if (!checking){
            model.addAttribute("exist",true);
            return "back/AdminAdd";
        }

        adminService.add(admin);
        model.addAttribute("check",true);
        return "back/AdminAdd";
    }

    /**
     * 修改管理员
     * @param admin
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("adminUpdate")
    public String updateAdmin(Admin admin, String name, Model model){
        if (admin == null){
            return "static_page/Error";
        }

        boolean checking = adminService.exist(name);
        if (!checking){
            model.addAttribute("checkExist",true);
            return "redirect:/back/adminList";
        }

        adminService.update(admin);
        return "redirect:/back/adminList";

    }


    /**后台管理登录*/
    @RequestMapping("adminLogin")
    public String login(String name, String password, HttpSession session)  {
        //用户名或者密码为空的话，则跳转到登录错误界面

        if (name == null||password ==null){
            return "static_page/Error";
        }

        //用户名和密码错误，跳转到提示页面
        Admin admin = adminService.get(name,password);
        if (admin == null){
            session.setAttribute("loginError",true);
            return "back/login";
        }

        //用户名和密码正确，向前端传参，并跳转到后台管理系统页面
        session.setAttribute("admin",admin.getName());
        return "static_page/home";
    }



}
