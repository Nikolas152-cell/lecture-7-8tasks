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

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;



    @RequestMapping ("/books")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Book> index(Model model)
    {
        model.addAttribute("books" ,bookService.allBooks());
        System.out.println(bookService.allBooks().size());
        List<Book> test = bookService.allBooks();
        return test;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/books/{id}")
    public Object show(@PathVariable("id") int id, Model model)
    {
        if(bookService.get(id) == null)
        {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("book", bookService.get(id));
        return bookService.get(id);
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

    @CrossOrigin(origins = {"http://localhost:3000/create", "http://localhost:3000"})
    @PostMapping("/books/create")
    public ResponseEntity create(@RequestBody Book book){
        bookService.create(book);
        return ResponseEntity.ok("Book was saved");
    }

    @GetMapping("/books/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("book", bookService.get(id));
        return "books/edit";
    }

    @CrossOrigin(origins = {"http://localhost:3000/create", "http://localhost:3000", "http://localhost:3000/edit{id}"
    ,"http://localhost:3000/edit"})
    @PutMapping ("/books/{id}")
    public ResponseEntity update(@RequestBody Book book)
    {
        bookService.update(book, book.getTitle());
        return ResponseEntity.ok("book was updated");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable("id") int id, @ModelAttribute("author") Author author)
    {
        bookService.delete(id);
        return "redirect:/books";
    }

}
