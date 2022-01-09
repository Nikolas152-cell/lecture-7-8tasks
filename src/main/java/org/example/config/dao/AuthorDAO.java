package org.example.config.dao;

import org.example.config.models.Author;
import org.example.config.models.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorDAO {
    private List<Author> authors;

    {
        authors = new ArrayList<>();
        Author author = new Author();
        Book book = new Book();
        book.setTitle("Some book");
        book.setId(2);
        author.setName("Some author");
        author.setId(1);
        authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
