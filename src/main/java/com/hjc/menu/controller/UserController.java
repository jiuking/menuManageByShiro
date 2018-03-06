package com.hjc.menu.controller;

import com.hjc.menu.persistence.entity.User;
import com.hjc.menu.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "showUser")
    public String index(HttpServletRequest request,Model model) {
        String id = request.getParameter("id");
        log.info("id:{}",id);
        User user = userService.getUserById(1);
        model.addAttribute("user", user);
        return "showUser";
    }
}
