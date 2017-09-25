package com.valerastudy.BookApp.database;

import com.valerastudy.BookApp.model.Book;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DbImpl {

    private static Session session;

    public List<Book> findAll() {
        session = DbUtil.getSession();
        List<Book> books = new ArrayList<Book>();
        Query query = session.createQuery("from Book");
        books = query.list();
        DbUtil.closeSession();
        if (books.size() > 0) {return books;}
        else return null;
    }

    public Book findById(int bookId) {
        session = DbUtil.getSession();
        List<Book> books = new ArrayList<Book>();
        books = session.createCriteria(Book.class)
                .add(Restrictions.eq("bookId", bookId))
                .list();
        DbUtil.closeSession();
        if (books.size() > 0) {return books.get(0);}
        else return null;
    }

    public Book findByName(String bookName) {
        session = DbUtil.getSession();
        List<Book> books = new ArrayList<Book>();
        books = session.createCriteria(Book.class)
                .add(Restrictions.eq("bookName", bookName))
                .list();
        DbUtil.closeSession();
        if (books.size() > 0) {return books.get(0);}
        else return null;
    }

    public boolean deleteById(int bookId) {
        session = DbUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Book where bookId = :id")
                .setParameter("id", bookId);
        query.executeUpdate();
        session.getTransaction().commit();

        query = session.createQuery("from Book where bookId = :id")
                .setParameter("id", bookId);
        List<Book> books = query.list();
        DbUtil.closeSession();

        if (books == null || books.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean updateBook(Book book) {
        if (checkBook(book)) {
            session = DbUtil.getSession();
            session.beginTransaction();
            Book entityBook = session.get(Book.class, book.getBookId());
            copyBookObject(entityBook, book);
            session.update(entityBook);
            session.getTransaction().commit();
            DbUtil.closeSession();
            return true;
        } else {
            return false;
        }
    }

    /**
     * public static int saveBook(Book book);
     * @param book
     * @return
     * 0 - object saved successful
     * 1 - object already exist in DB
     * -1 - error on saving object
     */
    public int saveBook(Book book) {
        if (!checkBook(book)) {
            session = DbUtil.getSession();
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            DbUtil.closeSession();
            if (!checkBook(book))
                return -1;
            else return 0;
        } else return 1;
    }

    public int getMaxId(){
        session = DbUtil.getSession();
        List<Integer> books = new ArrayList<Integer>();
        Query query = session.createQuery("select max(bookId) from Book");
        books = query.list();
        DbUtil.closeSession();
        return books.get(0);
    }

    private boolean checkBook(Book book) {
        Book book2 = new Book();
        book2 = findById(book.getBookId());
        if (book2 == null){
            return false;
        }
        else {
            return true;
        }
    }

    private void copyBookObject(Book entityBook, Book book){
        entityBook.setBookId(book.getBookId());
        entityBook.setBookName(book.getBookName());
        entityBook.setBookAuthor(book.getBookAuthor());
        entityBook.setNrOfPages(book.getNrOfPages());
    }
}
