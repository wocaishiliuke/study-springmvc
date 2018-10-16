package com.baicai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    /*@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("msg", "Hello world!");
        return "hello";
    }*/

    /**
     * 测试@RequestMapping中的属性
     * @return
     */
    @RequestMapping(value = "/testParam",
            method = {RequestMethod.GET, RequestMethod.POST},
            consumes = "text/html",
            produces = {"application/json", "text/html"},
            params = {"param1=a", "param2=b"},
            headers = "Referer=http://www.baidu.com")
    public ModelAndView testParam() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "Hello world!");
        return mv;
    }

    /**
     * 标准URL路径
     * http://localhost:9091/hello/test1
     * @return
     */
    @RequestMapping(value = "/test1")
    public ModelAndView test1() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "标准URL");
        return mv;
    }

    /**
     * Ant通配符风格?
     * @return
     */
    @RequestMapping(value = "/?/test2")
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "Ant风格?");
        return mv;
    }

    /**
     * Ant通配符风格*
     * @return
     */
    @RequestMapping(value = "/*/test3")
    public ModelAndView test3() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "Ant风格*");
        return mv;
    }

    /**
     * Ant通配符风格**
     * @return
     */
    @RequestMapping(value = "/**/test4")
    public ModelAndView test4() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "Ant风格**");
        return mv;
    }

    /**
     * Rest占位符风格{}
     * @return
     */
    @RequestMapping(value = "/{name}/{id}/test5")
    public ModelAndView test5(@PathVariable("name") String name, @PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "Rest占位符风格: name=" + name + ", id=" + id);
        return mv;
    }
}
