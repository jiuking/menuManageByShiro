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
        System.out.println("asdf");
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        subject.login(token);
//        result = "SUCCESS";//登录成功
        /**
         * forward 转发，如return "forward:/hello"; 浏览器的地址栏不会变，但是有视图返回来

         redirect 重定向，如return "redirect:/hello"; 浏览器的地址栏会变。


         spring控制器最后返回一个ModelAndView(urlName),其中urNamel可以是一个视图名称,由视图解析器负责解析后将响应流写回客户端;也可以通过redirect/forward:url方式转到另一个控制器进行处理.

         redirect方式相当于”response.sendRedirect()”.这种方式外部特征就是浏览器地址栏最后显示的路径是转发后的新的路径.工作方式是这样的, 服务器端会首先发一个response给浏览器, 然后浏览器收到这个response后再发一个requeset给服务器, 然后服务器发新的response给浏览器. 这时页面收到的request是一个新从浏览器发来的.这种方式的结果是:

         A.在转发前后有两个不同的request对象,转发前后的两个控制器在request上的参数(request.getParameter())和request属性(request.getAttribute())不能共享;

         B.如果转发前后的两个控制器都配置在spring 拦截器范围内,这样拦截器会拦截前后两个request,即会拦截两次;

         C.最后返回到浏览器后,因为地址栏显示的是转发后的url,所以刷新页面时只会执行后面的url映射的控制器.



         forward方式相当于request.getRequestDispatcher().forward(request,response)，这种方式的外部特征是浏览器地址显示的路径是转发前的路径.工作方式是这样,forward 发生在服务器内部,在前一个控制器处理完毕后,直接进入下一个控制器处理, 并将最后的response发给浏览器. 这种方式的结果是:

         A.转发前后是同一个request,后一个控制器可共享前一个控制器的参数与属性;

         B.因为是同一个request,拦截器只会拦截前一个url,如果前一个url在映射时未配置到拦截器拦截，则拦截后一个url，即只拦截一次;

         C.最后返回到浏览器后,因为地址栏显示的是转发前的url,所以刷新页面时会依次执行前后两个控制器.


         */
//        return "redirect:/success";//forward
//        return "redirect:/success";
        return "login";
    }

    @RequestMapping("/")
    public String index1() {
        return "login";
    }

    @RequestMapping(value = "/success", produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
    public String success() {
        return new String("success");
    }
}
