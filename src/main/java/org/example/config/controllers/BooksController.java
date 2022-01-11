package org.example.config.controllers;

import org.example.config.models.Author;
import org.example.config.models.Book;
import org.example.config.services.AuthorService;
import org.example.config.services.BookService;
import org.example.config.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;



    @GetMapping("/books")
    public String index(Model model)
    {
        model.addAttribute("books" ,bookService.allBooks());
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

    @GetMapping("/books/new")
    public String newBook(Model model)
    {
        model.addAttribute("book", new Book());
        model.addAttribute("author", new Author());
        return "books/new";
    }

    @PostMapping("/books")
    public String create(@ModelAttribute ("book") Book book, @ModelAttribute("author") Author author)
    {
        bookService.create(book, book.getAuthor().getId(), book.getAuthor().getName());
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
        bookService.update(book, book.getTitle());
        return "redirect:/books";
    }

    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable("id") int id, @ModelAttribute("author") Author author)
    {
        bookService.delete(id);
        return "redirect:/books";
    }

}
