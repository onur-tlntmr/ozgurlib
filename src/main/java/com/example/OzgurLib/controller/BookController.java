package com.example.OzgurLib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/list")
    public String showList(){
        return "/lists/book-list";
    }

}
