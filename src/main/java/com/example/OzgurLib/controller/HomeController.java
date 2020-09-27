package com.example.OzgurLib.controller;

import com.example.OzgurLib.entities.Book;
import com.example.OzgurLib.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    BookRepo bookRepo;


    @GetMapping("/")
    public String showIndex(Model model){

        var books = bookRepo.findAll();


        model.addAttribute("bookList",books);

        return "index";
    }


}
