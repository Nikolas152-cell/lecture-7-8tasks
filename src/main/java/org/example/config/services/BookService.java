package org.example.config.services;

import org.example.config.models.Book;

import java.util.List;

public interface BookService {
    List<Book> readAll();

    Book get(int id);

    void create(Book book);

    void delete(int id);

    void update(Book book, int id);


}
