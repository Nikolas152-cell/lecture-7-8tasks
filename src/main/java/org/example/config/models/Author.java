package org.example.config.models;


import javax.persistence.*;
import java.util.*;

@Table(name = "authors")
@Entity(name = "author")
public class Author {
    private String name;


    private Set<Book> books = new HashSet<>();

    public void addBook(Book book)
    {
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book)
    {
        this.books.remove(book);
        book.setAuthor(null);
    }

    @OneToMany(mappedBy = "author",orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
        for (Book book: books) {
            book.setAuthor(this);
        }
    }

    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Author(String name)
    {
        this.name = name;
    }

    public Author()
    {

    }

}
