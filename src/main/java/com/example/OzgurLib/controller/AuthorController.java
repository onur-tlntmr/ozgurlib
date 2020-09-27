package com.example.OzgurLib.controller;

import com.example.OzgurLib.entities.Author;
import com.example.OzgurLib.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepo authorRepo;


    @GetMapping("/list")
    public String showList(Model model) {

        var authors = authorRepo.findAll();

        model.addAttribute("authors", authors);

        return "lists/author-list";
    }

    @GetMapping("/showFormForAdd")
    public String showForAddForm(Model model) {

        Author author = new Author();

        model.addAttribute("author", author);

        return "forms/author-form";

    }


    @PostMapping("/save")
    public String save(@RequestParam("picture") MultipartFile file, @ModelAttribute("author") Author author) {

        String encodedPicture = null;

        try {
            encodedPicture = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        author.setPhoto(encodedPicture);

        author.setId(0l); //for new record

        authorRepo.save(author);

        return "redirect:/author/list";

    }


}
