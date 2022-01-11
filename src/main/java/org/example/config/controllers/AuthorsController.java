package org.example.config.controllers;

import org.example.config.dao.AuthorDAO;
import org.example.config.services.AuthorService;
import org.example.config.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorsController {
    @Autowired
    private AuthorService authorService;



    @GetMapping("/authors")
    public String index(Model model)
    {
        model.addAttribute("authors" ,authorService.readAll());
        return "authors/index";
    }


}
