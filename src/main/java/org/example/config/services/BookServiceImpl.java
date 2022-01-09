package org.example.config.services;

import org.example.config.dao.BookDAO;
import org.example.config.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service("BookService")
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDAO bookDAO;
    private static final AtomicInteger BOOK_ID = new AtomicInteger();




    @Override
    public List<Book> readAll() {
        System.out.println(bookDAO.getBooks());
        List<Book> bookList = bookDAO.getBooks();
        return bookList;
    }

    public Book get(int id)
    {
        return bookDAO.get(id);
    }

    public void create(Book book)
    {
        bookDAO.save(book, BOOK_ID.incrementAndGet());
    }

    public void update(Book book, int id)
    {
        bookDAO.update(id,book);
    }

    public void delete(int id)
    {
        bookDAO.delete(id);
    }

}
