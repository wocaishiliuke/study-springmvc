package com.baicai.controller;

import com.baicai.pojo.EasyUIPage;
import com.baicai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    // users.jsp路由
    @GetMapping(value = "/users")
    public String toUsers() {
        return "users";
    }

    /**
     * 获取用户分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/list")
    public EasyUIPage getUsers(@RequestParam("page") Integer pageNum,
                               @RequestParam("rows") Integer pageSize) {
        Integer start = (pageNum - 1) * pageSize;
        Integer end = start + pageSize;
        return this.userService.getUsers(start, end);
    }
}
