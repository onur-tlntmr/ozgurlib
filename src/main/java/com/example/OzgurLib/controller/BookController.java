package com.example.OzgurLib.controller;

import com.example.OzgurLib.entities.Book;
import com.example.OzgurLib.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Book book = new Book();

        model.addAttribute(book);

        return "forms/book-form";

    }

    @GetMapping("/showDetail")
    public  String showDetail(@RequestParam long id, Model model){

        Optional<Book> optionalBook = bookRepo.findById(id);

        Book book;

        if(optionalBook.isPresent()){
            book = optionalBook.get();
            model.addAttribute(book);
        }

        return "details/book-detail";


    }


}
