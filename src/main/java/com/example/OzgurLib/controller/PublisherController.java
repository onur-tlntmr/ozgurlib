package com.example.OzgurLib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/publisher")
@Controller
public class PublisherController {

    @GetMapping("/list")
    public String showList(){
        return "lists/publisher-list";
    }

}
