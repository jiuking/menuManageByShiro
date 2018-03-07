package com.hjc.menu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    //返回登录页面
    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "login",produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
    public String login() {
        String result = "";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");
        subject.login(token);
//        result = "SUCCESS";//登录成功
        return "login";
    }

    @RequestMapping(value = "/success", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String success() {
        return new String("Success");
    }
}
