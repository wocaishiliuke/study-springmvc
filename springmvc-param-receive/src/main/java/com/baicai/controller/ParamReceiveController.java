package com.baicai.controller;

import com.baicai.pojo.User;
import com.baicai.pojo.UserDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * 用于测试参数接收
 */
@Controller
@RequestMapping("/param")
//@SessionAttributes("user")
//@SessionAttributes(types = {User.class}, value = "user")
//@SessionAttributes(types = {User.class}, value = {"user"})
public class ParamReceiveController {
    private static final Log logger = LogFactory.getLog(ParamReceiveController.class);

    /**
     * 1.直接接收
     * @param username
     * @param id
     * @return
     */
    @RequestMapping("/test1")
    public String test1(String username, Long/*long*/ id) {
        System.out.println(username + " --- " + id);
        return "hello";
    }

    /**
     * 2.bean接收
     * @param user
     * @return
     */
    @RequestMapping("/test2")
    public String test2(User user) {
        System.out.println(user.toString());
        return "hello";
    }

    /**
     * 3.测试@RequestParam和@RequestBody的使用
     * @param request
     * @return
     */
    @RequestMapping("/test3")
    public String test3(@RequestParam(value = "username") String username,
                        @RequestParam(value = "id") Long id
                        /*@RequestBody() User user1*/, HttpServletRequest request) {
        //System.out.println(user1.toString());
        /*User user = new User();
        user.setId(id);
        user.setUsername(username);
        System.out.println(user.toString());*/

        Enumeration headerNames = request.getHeaderNames();
        System.out.println("--------请求头----------");
        while (headerNames.hasMoreElements()) {
            String k = (String) headerNames.nextElement();
            String v = request.getHeader(k);
            System.out.println(k + "=" + v);
        }
        System.out.println("--------请求体----------");
        //使用@RequestParam或@RequestBody后，request.getReader就获取不到了，流只能读一次
        System.out.println(getRequestBody(request));
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

    private String getRequestBody(final HttpServletRequest request) {
        final StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            if (reader == null) {
                logger.debug("Request body could not be read because it's empty.");
                return null;
            }
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (final Exception e) {
            logger.trace("Could not obtain the saml request body from the http request", e);
            return null;
        }
    }


    /**
     * 4.测试@RequestHeader
     * 注：不加HttpServletResponse做形参，会把param/testHeader作为视图名，报404
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
     * 5.测试@CookieValue
     * @param sessionId
     */
    @RequestMapping(value = "/testCookie")
    @ResponseStatus(HttpStatus.OK)
    public void testCookie(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId) {
        logger.info("JSESSIONID:" + sessionId);
    }


    /**
     * 6.测试@SessionAttributes
     */
    //跳转到register注册页（页面都走服务器端页面）
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //要先放入Model，才能被放入Session
        model.addAttribute("user", user);
        return "registerSuccess";
    }


    /**
     * 7.1 测试@ModelAttribute("")注释有返回值的方法
     */
    /*@ModelAttribute("msg")
    public String modelAttribute1(@RequestParam("username") String username) {
        return username;
    }*/
    /**
     * 7.2 测试@ModelAttribute注释有返回值的方法
     */
    /*@ModelAttribute
    //存入Model中的key是user
    public User modelAttribute2(@RequestParam("username") String username) {
        return find(username);
    }
    private User find(String username) {
        //模拟查找用户
        User user = new User();
        user.setUsername(username);
        return user;
    }*/
    /*@ModelAttribute
    //存入Model中的key是string
    public String modelAttribute2(@RequestParam("username") String username) {
        return username;
    }*/

    /**
     * 7.3 测试@ModelAttribute：注释void的方法
     */
    /*@ModelAttribute
    public void modelAttribute3(@RequestParam("username") String username, Model model) {
        model.addAttribute("msg", username);
    }*/

    @RequestMapping("/login1")
    public String login1() {
        return "hello";
    }

    /**
     * 7.4 测试@ModelAttribute+@RequestMapping
     * 相当于Model
     */
    @RequestMapping("/hello")
    @ModelAttribute("msg")
    public String login2(@RequestParam("username") String username) {
        return username + "123";
    }

    /**
     * 7.5 测试@ModelAttribute注释形参
     */
    @RequestMapping("/hello4")
    public String hello4(@RequestParam("username") String msg) {
        return "hello";
    }

    /**
     * 8.1 测试List接收
     * @return
     */
    @RequestMapping("/submitList")
    public String submitList() {
        return "submitList";
    }
    @RequestMapping("/testList")
    //public String testList(String username, String password, Boolean isMarry, String[] hobby/*List<String> hobby*/) {
    public String testList(UserDTO user, HttpServletRequest request) {
        System.out.println(user.toString());
        System.out.println(getRequestBody(request));
        /*System.out.println(username + " = " + password + " = " + isMarry);
        if (hobby != null && hobby.length > 0) {
            for(String h : hobby) {
                System.out.println(h);
            }
        }*/
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
}
