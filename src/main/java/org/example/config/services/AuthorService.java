package org.example.config.services;

import org.example.config.models.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> readAll();

}
