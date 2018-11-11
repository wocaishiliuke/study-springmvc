package com.baicai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class ForwardRedirectController {

    @GetMapping("/forward")
    public String testForward(Model model) {
        model.addAttribute("msg", "转发信息");
        //转发到forwardRedirect接口，或"forward:/forwardRedirect"
        return "forward:forwardRedirect";

        //转发到forwardRedirect.jsp的两种方式
        //return "forwardRedirect";
        //return "forward:WEB-INF/jsp/forwardRedirect.jsp";
    }

    @GetMapping("/forwardRedirect")
    public String forwardRedirect(@RequestParam(value = "redirectMsg1", required = false) String redirectMsg1,
                                  @RequestParam(value = "redirectMsg2", required = false) String redirectMsg2, Model model) {
        if (!StringUtils.isEmpty(redirectMsg1)) model.addAttribute("msg1", redirectMsg1);
        if (!StringUtils.isEmpty(redirectMsg2)) model.addAttribute("msg2", redirectMsg2);
        return "forwardRedirect";
    }

    @GetMapping("/redirect")
    public String testRedirect(RedirectAttributes attr, HttpServletResponse resp) throws UnsupportedEncodingException {
        attr.addAttribute("redirectMsg1", "redirect信息");
        return "redirect:forwardRedirect?redirectMsg2=" + URLEncoder.encode("测试乱码", "utf-8");//中文编码问题
    }
}
