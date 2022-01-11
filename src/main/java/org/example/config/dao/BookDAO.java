package org.example.config.dao;

import org.example.config.models.Author;
import org.example.config.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class BookDAO {
    private SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Book> allBooks()
    {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from book").list();
    }


    public Book getBook(long id)
    {
        Session session = sessionFactory.getCurrentSession();
        return (Book) session.get(Book.class, id);
    }

    public void save(Book book)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }

    public void update(Book book)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    public void delete(long id)
    {
        Session session = sessionFactory.getCurrentSession();
        Book deletedBook = this.getBook(id);
        Author author = deletedBook.getAuthor();
        //session.delete(author);
        session.delete(deletedBook);
    }

}
