package org.example.config.services;

import org.example.config.dao.AuthorDAO;
import org.example.config.dao.BookDAO;
import org.example.config.models.Author;
import org.example.config.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookServiceImpl implements BookService {




    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private AuthorDAO authorDAO;
    private static final AtomicInteger BOOK_ID = new AtomicInteger();

    @Transactional
    public List<Book> allBooks()
    {
        return bookDAO.allBooks();
    }


    @Transactional
    public Book get(long id)
    {
        return bookDAO.getBook(id);
    }


    private static int count = 0;
    @Transactional
    public void create(Book book, long authorId, String authorName)
    {
        Author author = new Author(authorName);
        author.addBook(book);
        author.setId(++count);
        authorDAO.addAuthor(author);
        book.setAuthor(author);
        bookDAO.save(book);
    }

    @Transactional
    public void update(Book book, String bookTitle)
    {
        book = bookDAO.getBook(book.getId());
        System.out.println(book.getId());
        authorDAO.updateAuthor(book.getAuthor());
        book.setTitle(bookTitle);
        bookDAO.update(book);
    }
    @Transactional
    public void delete(int id)
    {
        bookDAO.delete(id);
    }

}
