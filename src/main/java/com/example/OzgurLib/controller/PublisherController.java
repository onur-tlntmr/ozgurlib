package com.example.OzgurLib.controller;

import com.example.OzgurLib.entities.Publisher;
import com.example.OzgurLib.repositories.PublisherRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/publisher")
@Controller
public class PublisherController {

    private final PublisherRepo publisherRepo;

    //Autowired
    public PublisherController(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }


    @GetMapping("/list")
    public String showList(Model model){

        var publishers = publisherRepo.findAll();

        model.addAttribute("publisherList",publishers);


        return "lists/publisher-list";
    }

    @GetMapping("/showDetail")
    public String showDetail(@RequestParam int id,Model model){

        Optional<Publisher> optionalPublisher = publisherRepo.findById(id);

        if(optionalPublisher.isPresent()){
            Publisher publisher = optionalPublisher.get();

            model.addAttribute(publisher);

        }

        return "details/publisher-detail";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Publisher publisher = new Publisher();

        model.addAttribute(publisher);

        return "forms/publisher-form";

    }

    @PostMapping("/save")
    public String Save(@ModelAttribute("publisher") Publisher publisher){


        publisherRepo.save(publisher);


        return "redirect:/publisher/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam int id){

        publisherRepo.deleteById(id);

        return "redirect:/publisher/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam int id, Model model){

        Optional<Publisher> optionalPublisher = publisherRepo.findById(id);

        if(optionalPublisher.isPresent()){
            Publisher publisher = optionalPublisher.get();

            model.addAttribute(publisher);

        }

        return "forms/publisher-form";

    }




}