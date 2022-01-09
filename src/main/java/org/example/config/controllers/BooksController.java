package org.example.config.controllers;

import org.example.config.dao.BookDAO;
import org.example.config.models.Book;
import org.example.config.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BooksController {
    private final BookServiceImpl bookService;
    @Autowired
    public BooksController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String index(Model model)
    {
        model.addAttribute("books" ,bookService.readAll());
        return "books/index";
    }
    @GetMapping("/books/{id}")
    public Object show(@PathVariable("id") int id, Model model)
    {
        if(bookService.get(id) == null)
        {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("book", bookService.get(id));
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
        bookService.create(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("book", bookService.get(id));
        return "books/edit";
    }
    @PutMapping ("/books/{id}")
    public String update(@ModelAttribute("book") Book book,
                         @PathVariable("id") int id)
    {
        bookService.update(book, id);
        return "redirect:/books";
    }

    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable("id") int id)
    {
        bookService.delete(id);
        return "redirect:/books";
    }

}
