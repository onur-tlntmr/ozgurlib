package com.example.OzgurLib.controller;

import com.example.OzgurLib.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookRepo bookRepo;


    //Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @GetMapping("/list")
    public String showList(Model model){

        var bookList = bookRepo.findAll();

        model.addAttribute(bookList);


        return "/lists/book-list";
    }

}
