package org.example.config.services;

import org.example.config.dao.AuthorDAO;
import org.example.config.models.Author;

import java.util.List;

public class AuthorServiceImpl implements AuthorService{
    private AuthorDAO authorDAO;
    @Override
    public List<Author> readAll() {
        return authorDAO.getAuthors();
    }
}
