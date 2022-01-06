package org.example.config.dao;

import org.example.config.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDAO {
    private List<Book> books;
    public static int COUNT = 0;

    public List<Book> getBooks() {
        return books;
    }

    {
        books = new ArrayList<>();
        Book book = new Book();
        book.setId(++COUNT);
        book.setTitle("Some book");
        books.add(book);
        Book book1 = new Book();
        book1.setId(++COUNT);
        book1.setTitle("Some book1");
        books.add(book1);
    }
    public Book show(int id)
    {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void save(Book book)
    {
        book.setId(++COUNT);
        books.add(book);
    }

    public void update(int id, Book book)
    {
        Book bookToBeUpdated = show(id);
        bookToBeUpdated.setTitle(book.getTitle());
    }

    public void delete(int id)
    {
        books.removeIf(book -> book.getId() == id);
    }

}
