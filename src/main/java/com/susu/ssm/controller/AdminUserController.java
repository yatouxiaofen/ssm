package com.susu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminUserController
{
    @RequestMapping("/home")
    public String home(){
        return "admin/home";
    }
}
