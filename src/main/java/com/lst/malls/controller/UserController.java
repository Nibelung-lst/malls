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
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Controller
@RequestMapping("back")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 用户显示
     * @param pageNumber
     * @param model
     * @return
     */
    @RequestMapping("userList")
    public String List(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber, Model model){


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
     * @param status
     * @param id
     * @param pageNumber
     * @return
     */
    @RequestMapping("userStatus")
    public String ChangeStatus(boolean status,Integer id,Integer pageNumber){
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
