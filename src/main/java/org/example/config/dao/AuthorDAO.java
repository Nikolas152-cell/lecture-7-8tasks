package org.example.config.dao;

import org.example.config.models.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthorDAO {

    private SessionFactory sessionFactory;



    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List getAuthors()
    {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from author").list();
    }

    public long getIdByAuthor(Author author)
    {
        return author.getId();
    }


    public Author getAuthor(long id)
    {
        Session session = sessionFactory.getCurrentSession();
        return (Author) session.get(Author.class, id);
    }

    public void addAuthor(Author author)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(author);
    }

    public void deleteAuthor(long id)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(this.getAuthor(id));
    }


    public void updateAuthor(Author author)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(author);
    }




}
