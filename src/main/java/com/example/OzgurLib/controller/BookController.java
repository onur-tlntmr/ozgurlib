package com.example.OzgurLib.controller;

import com.example.OzgurLib.entities.Author;
import com.example.OzgurLib.entities.Book;
import com.example.OzgurLib.entities.Publisher;
import com.example.OzgurLib.repositories.AuthorRepo;
import com.example.OzgurLib.repositories.BookRepo;
import com.example.OzgurLib.repositories.PublisherRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookRepo bookRepo;

    private final AuthorRepo authorRepo;

    private final PublisherRepo publisherRepo;


    //Autowired
    public BookController(BookRepo bookRepo,AuthorRepo authorRepo,PublisherRepo publisherRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.publisherRepo = publisherRepo;
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

        //for options
        List<Author> authorList = authorRepo.findAll();

        List<Publisher> publisherList = publisherRepo.findAll();

        model.addAttribute(book);

        model.addAttribute(authorList);

        model.addAttribute(publisherList);

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


    @PostMapping("/save")
    public String save(@RequestParam("photo")MultipartFile file, @ModelAttribute("book") Book book ){

        String encodedPicture = null;
        try {
            encodedPicture = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        book.setPicture(encodedPicture);


        bookRepo.save(book);

        return "redirect:/book/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        bookRepo.deleteById(id);

        return "redirect:/book/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") Long id,Model model){


        Optional<Book> optionalBook = bookRepo.findById(id);

        //for options
        List<Author> authorList = authorRepo.findAll();

        List<Publisher> publisherList = publisherRepo.findAll();


        model.addAttribute(authorList);

        model.addAttribute(publisherList);


        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            model.addAttribute(book);
        }

        return "forms/book-form";

    }

}
