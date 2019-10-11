package com.lst.malls.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lst.malls.pojo.User;
import com.lst.malls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author :Nibelung
 * @Date ：Created in 9:59 2019/9/18
 * @Description :用户controller
 */
@Controller
@RequestMapping("back")
public class UserController {
    /**
     * 用户service
     */
    @Autowired
    UserService userService;

    /**
     * 用户显示
     * @param pageNumber 分页页数
     * @param model 前台传参
     * @return 跳转到相应页面
     */
    @RequestMapping("userList")
    public String list(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber, Model model){


        //设置起始页，每页展示5条数据
        PageHelper.startPage(pageNumber,5);
        //将user表下的数据传入到users数组里
        java.util.List<User> users = userService.list();
        //使用pageInfo包装查询后的结果,只需要将pageInfo交给页面就行了
        PageInfo page = new PageInfo(users,5);
        //通过model将page传递到前台
        model.addAttribute("UserPageInfo",page);
        return "back/UserList";
    }

    /**
     * 用户状态改变
     * @param status 前台传递回来的用户状态（冻结/解冻）
     * @param id 更改状态的用户的主键
     * @param pageNumber 分页页数
     * @return 跳转到相应页面
     */
    @RequestMapping("userStatus")
    public String changeStatus(boolean status, Integer id, Integer pageNumber){
        System.out.println(status);
        User user =new User();
        user.setId(id);
        if (status){
            userService.change(true,user);
        }
        else {
            userService.change(false,user);
        }
        return "redirect:/back/userList?pageNumber="+ pageNumber;
    }

}
