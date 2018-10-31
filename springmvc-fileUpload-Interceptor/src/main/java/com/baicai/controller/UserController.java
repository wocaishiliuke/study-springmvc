package com.baicai.controller;

import com.baicai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @RequestMapping(value = "/login")
    public ModelAndView login(String username, String password, ModelAndView mv, HttpSession session) {
        //模拟登录
        if (username != null && "tony".equals(username)
            && password != null && "123".equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user", user);
            mv.setViewName("redirect:interceptor/index");
        }else {
            mv.addObject("message", "登录失败，请重试！");
            mv.setViewName("interceptor/login");
        }
        return mv;
    }
}
