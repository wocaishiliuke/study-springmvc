package com.baicai.controller;

import com.baicai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String loginForm(){
        return "interceptor/loginForm";//页面路由（没有报错信息）
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, ModelAndView mv, HttpSession session) {
        //模拟登录
        if (username != null && "tony".equals(username)
            && password != null && "123".equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user", user);
            //登录成功跳转到首页的接口（而非页面）
            mv.setViewName("redirect:index");
        }else {
            //登录失败，再登录
            mv.addObject("message", "登录失败，请重试！");
            mv.setViewName("interceptor/loginForm");
        }
        return mv;
    }
}
