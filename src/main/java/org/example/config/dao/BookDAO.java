package org.example.config.dao;

import org.example.config.models.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class BookDAO {
    private List<Book> books;


    public List<Book> getBooks() {
        return books;
    }

    {
        books = new ArrayList<>();
        Book book = new Book();
        book.setId(2);
        book.setTitle("Some book");
        books.add(book);
        Book book1 = new Book();
        book1.setId(3);
        book1.setTitle("Some book1");
        books.add(book1);
    }
    public Book get(int id)
    {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void save(Book book, int id)
    {
        book.setId(id);
        books.add(book);
    }

    public void update(int id, Book book)
    {
        Book bookToBeUpdated = get(id);
        bookToBeUpdated.setTitle(book.getTitle());
    }

    public void delete(int id)
    {
        books.removeIf(book -> book.getId() == id);
    }

}
