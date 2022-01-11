package org.example.config.services;

import org.example.config.dao.AuthorDAO;
import org.example.config.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorDAO authorDAO;
    @Override
    @Transactional
    public List readAll() {
        return authorDAO.getAuthors();
    }

    @Transactional
    @Override
    public Author getAuthor(long id) {
        return authorDAO.getAuthor(id);
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorDAO.addAuthor(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(long id) {
        authorDAO.deleteAuthor(id);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        authorDAO.updateAuthor(author);
    }
}
