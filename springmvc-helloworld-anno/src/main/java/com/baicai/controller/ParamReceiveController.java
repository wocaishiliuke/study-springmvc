package com.baicai.controller;

import com.baicai.pojo.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Map;

/**
 * 用于测试参数接收
 */
@Controller
@RequestMapping("/param")
public class ParamReceiveController {
    private static final Log logger = LogFactory.getLog(ParamReceiveController.class);

    @RequestMapping("/test1")
    public String test1(/*@RequestParam(value = "username", required = false) String username,
                       @RequestParam(value = "id", required = false) Long id,*/
                        /*@RequestBody()*/ User user1, Model model, HttpServletRequest request) {
        System.out.println(user1.toString());
        User user = new User();
        /*user.setId(id);
        user.setUsername(username);*/
        System.out.println(user.toString());
        model.addAttribute("msg", user.toString());
        Enumeration headerNames = request.getHeaderNames();
        System.out.println("--------请求头----------");
        while (headerNames.hasMoreElements()) {
            String k = (String) headerNames.nextElement();
            String v = request.getHeader(k);
            System.out.println(k + "=" + v);
        }
        System.out.println("--------请求体----------");
        Enumeration attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String k = (String) attributeNames.nextElement();
            String v = request.getHeader(k);
            System.out.println(k + "=" + v);
        }
        System.out.println("--------请求参数----------");
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = (String) parameterNames.nextElement();
            String value = request.getParameter(element);
            System.out.println(element + "=" + value);
        }
        System.out.println("-------------------------");
        return "hello";
    }

    /**
     * 测试@RequestHeader
     * 注：不加HttpServletResponse做形参，会把testHeader作为视图名，报404
     * @param agent
     * @param accepts
     */
    @RequestMapping("testHeader")
    public void testHeader(@RequestHeader("User-Agent") String agent,
                           @RequestHeader("Accept") String[] accepts, HttpServletResponse response) {
        logger.info("User-Agent:" + agent);
        for (String accept : accepts) {
            logger.info(accept);
        }

    }

    /**
     * 测试@CookieValue
     * @param sessionId
     */
    @RequestMapping(value = "/testCookie")
    @ResponseStatus(HttpStatus.OK)
    public void testCookie(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId) {
        logger.info("JSESSIONID:" + sessionId);
    }
}
