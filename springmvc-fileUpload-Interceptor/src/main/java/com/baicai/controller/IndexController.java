package com.baicai.controller;

import com.baicai.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("how-java-program-runs.jpg", "西游记1", "吴承恩1", 74.21));
        books.add(new Book("jdk-jre-jvm.jpg", "西游记2", "吴承恩2", 74.22));
        books.add(new Book("jvm-architecture.png", "西游记3", "吴承恩3", 74.23));
        books.add(new Book("note01_01.png", "西游记4", "吴承恩4", 74.24));
        model.addAttribute("books", books);
        return "interceptor/index";
    }
}
