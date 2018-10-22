package com.baicai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用于测试Model、ModelMap、ModelAndiew的使用
 * 用于测试
 */
@Controller
@RequestMapping("/method")
public class HandlerMethodController {

    /**
     * Model或ModelMap
     * @param model
     * @return
     */
    @RequestMapping("method1")
    public String method1(ModelMap model /**Model model*/) {
        model.addAttribute("msg", "使用Model");
        return "hello";
    }

    /**
     * ModelAndView
     * @return
     */
    @RequestMapping("method2")
    public ModelAndView method2() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "使用ModelAndView");
        mv.setViewName("hello");
        return mv;
    }

    /**
     * HttpServletRequest、HttpServletResponse、session
     * @return
     */
    @RequestMapping("method3")
    public String method3(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        StringBuffer sb = new StringBuffer();
        sb.append("request：" + request + "<br/>");
        sb.append("response：" + response + "<br/>");
        sb.append("session：" + session + "<br/>");
        sb.append("request.URI：" + request.getRequestURI() + "<br/>");
        sb.append("sessionId：" + session.getId() + "<br/>");
        model.addAttribute("msg", sb.toString());
        return "hello";
    }
}
