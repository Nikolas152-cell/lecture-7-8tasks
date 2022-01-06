package org.example.config.controllers;

import org.example.config.dao.BookDAO;
import org.example.config.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BooksController {
    private BookDAO bookDAO;
    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping("/books")
    public String index(Model model)
    {
        model.addAttribute("books" ,bookDAO.getBooks());
        return "books/index";
    }
    @GetMapping("/books/{id}")
    public String show(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("book", bookDAO.show(id));
        return "books/show";
    }

    @GetMapping("books/new")
    public String newBook(Model model)
    {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping("/books")
    public String create(@ModelAttribute ("book") Book book)
    {
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }
    @PatchMapping("/books/{id}")
    public String update(@ModelAttribute("book") Book book,
                         @PathVariable("id") int id)
    {
        bookDAO.update(id,book);
        return "redirect:/books";
    }

    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable("id") int id)
    {
        bookDAO.delete(id);
        return "redirect:/books";
    }

}
