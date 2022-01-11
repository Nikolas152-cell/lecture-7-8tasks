package org.example.config.models;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity(name = "book")
@Table(name = "books")
public class Book {
    private String title;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }
    public Book()
    {

    }
}
