package com.hjc.menu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    private final static Logger log = LoggerFactory.getLogger(LoginController.class);

    //返回登录页面
    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "login",produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
    public String login(String username,String password) {
        String result = "";
        log.info("用户名:{}",username);
        log.info("密码:{}",password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);
//        result = "SUCCESS";//登录成功
        return "redirect:/success";
    }

    @RequestMapping(value = "/success", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String success() {
        return new String("Success");
    }
}
