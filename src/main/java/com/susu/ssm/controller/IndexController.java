package com.susu.ssm.controller;

import common.framework.bean.ResultBean;
import common.framework.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController
{
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("")
    public String index(){
        return "admin/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean<String> login(HttpSession session, String username) {
        logger.info("login user:" + username);

        // TODO 只是模拟登陆
        session.setAttribute(UserUtil.KEY_USER, username);

        return new ResultBean<String>(username);
    }
}
