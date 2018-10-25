package com.baicai.controller;

import com.baicai.pojo.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @RequestMapping(value = "/book")
    public String book() {
        return "book";
    }

    @RequestMapping(value = "/testRequestBody")
    public void testRequestBody(@RequestBody Book book, HttpServletResponse response) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(book.toString());
        System.out.println(mapper.writeValueAsString(book));

        book.setAuthor("白菜饼");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(mapper.writeValueAsString(book));
    }
}

