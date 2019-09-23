package com.lst.malls.controller;

import com.lst.malls.pojo.User;
import com.lst.malls.service.CategoryService;
import com.lst.malls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author :Nibelung
 * @Date ：Created in 17:26 2019/9/20
 * @Description :
 * @Modified By :
 * @Version : $
 */
@RequestMapping("fore")
@Service
public class ForePageController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    /**后台管理登录*/
    @RequestMapping("Fore_Login")
    public String login(String name, String password, HttpSession session,Model model)  {
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
        session.setAttribute("user",user.getName());
        return "fore/fore";
    }

    /**
     * 脱出登录
     * @param session
     * @return
     */
    @RequestMapping("Fore_LoginOut")
    public String loginout(HttpSession session){
        session.removeAttribute("ForeLoginError");
        session.removeAttribute("user");
        return "fore/fore";
    }

    /**
     * 注册
     * @param user
     * @param model
     * @param name
     * @param sexCheck
     * @return
     */
    @RequestMapping("Fore_Register")
    public String register(User user,Model model,String name,String sexCheck){
        String a = "1",b="0";
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
            userService.add(user);
            model.addAttribute("RegisterSucceed", true);
            return "fore/ForeRegister";

    }
}
