package org.example.config.services;

import org.example.config.models.Author;
import org.example.config.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {


    List<Book> allBooks();

    Book get(long id);

    void create(Book book,long authorId, String authorName);

    void delete(int id);

    void update(Book book, String bookTitle);


}
