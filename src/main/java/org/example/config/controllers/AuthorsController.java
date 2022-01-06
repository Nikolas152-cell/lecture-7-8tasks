package org.example.config.controllers;

import org.example.config.dao.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorsController {
    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorsController(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @GetMapping("/authors")
    public String index(Model model)
    {
        model.addAttribute("authors" ,authorDAO.getAuthors());
        return "authors/index";
    }


}
