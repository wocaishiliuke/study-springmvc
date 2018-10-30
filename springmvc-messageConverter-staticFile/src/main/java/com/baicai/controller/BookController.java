package com.baicai.controller;

import com.alibaba.fastjson.JSONObject;
import com.baicai.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试JSON转换
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @RequestMapping(value = "/book")
    public String book() {
        return "book";
    }

    @RequestMapping(value = "/testRequestBody")
    public void testRequestBody(@RequestBody Book book, HttpServletResponse response) throws Exception {
        // Jackson
        /*ObjectMapper mapper = new ObjectMapper();
        System.out.println(book.toString());
        System.out.println(mapper.writeValueAsString(book));

        book.setAuthor("白菜饼");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(mapper.writeValueAsString(book));*/

        //fastJson
        System.out.println(JSONObject.toJSONString(book));
        book.setAuthor("白菜饼fastJson");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(JSONObject.toJSONString(book));
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "bookList";
    }

    @ResponseBody
    @RequestMapping(value = "/getBooks")
    public List getBooks() {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1, "一清片", "刘能"));
        list.add(new Book(2, "黄连上清片", "赵四"));
        return list;
    }
}

