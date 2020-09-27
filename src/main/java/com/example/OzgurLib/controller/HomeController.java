package com.example.OzgurLib.controller;

import com.example.OzgurLib.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    final BookRepo bookRepo;

    //Autowired

    public HomeController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @GetMapping("/")
    public String showIndex(Model model){

        var books = bookRepo.findAll();


        model.addAttribute("bookList",books);

        return "index";
    }


}
