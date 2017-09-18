package com.valerastudy.BookApp.config;

import com.valerastudy.BookApp.model.Book;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HibernateUtils {
    public static String hibernateCfgXml = "hibernate\\hibernate.cfg.xml";

    private Session getSession(){
        return new Configuration().configure(hibernateCfgXml).buildSessionFactory().openSession();
    }

    public List<Book> findAll() {
        Session session = this.getSession();
        List<Book> books = new ArrayList<Book>();
        Query query = session.createQuery("from Book");
        books = query.list();
        session.close();
        return books;
    }

    public List<Book> findById(int bookId) {
        Session session = this.getSession();
        List<Book> books = new ArrayList<Book>();
        books = session.createCriteria(Book.class)
                .add(Restrictions.eq("bookId", bookId))
                .list();
        session.close();
        return books;
    }

    public List<Book> findByName(String bookName) {
        Session session = this.getSession();
        List<Book> books = new ArrayList<Book>();
        books = session.createCriteria(Book.class)
                .add(Restrictions.eq("bookName", bookName))
                .list();
        session.close();
        return books;
    }

    public boolean deleteById(int bookId) {
        Session session = this.getSession();
        session.beginTransaction();
        Query query = session.createQuery("delete Book where bookId = :id")
                .setParameter("id", bookId);
        session.getTransaction().commit();

        query = session.createQuery("from Book where bookId = :id")
                .setParameter("id", bookId);
        List<Book> books = query.list();

        session.close();

        if(books.size() == 0) return true;
        else return false;
    }

    public boolean updateBook(Book book) {
        return false;
    }

    public boolean saveBook(Book book) {
        return false;
    }




}
