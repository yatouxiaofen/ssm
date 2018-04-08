package com.susu.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.susu.ssm.bean.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.susu.ssm.pojo.User;
import com.susu.ssm.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Resource
    private UserService userService;
    
    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping("/getAllUserJson")
    @ResponseBody
    public ResultBean<List<User>> getAllUserJson(HttpServletRequest request, Model model){
        return new ResultBean<List<User>>(this.userService.getUserList());
    }
}
