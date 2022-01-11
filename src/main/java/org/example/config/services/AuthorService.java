package org.example.config.services;

import org.example.config.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<Author> readAll();

    public Author getAuthor(long id);

    public void saveAuthor(Author author);

    public void deleteAuthor(long id);

    public void updateAuthor(Author author);

}
