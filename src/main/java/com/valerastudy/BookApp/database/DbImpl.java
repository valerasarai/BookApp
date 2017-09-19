package com.valerastudy.BookApp.database;

import com.valerastudy.BookApp.model.Book;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DbImpl {

    private static Session session = DbUtil.getSession();

    public static List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();
        Query query = session.createQuery("from Book");
        books = query.list();
        return books;
    }

    public static List<Book> findById(int bookId) {
        List<Book> books = new ArrayList<Book>();
        books = session.createCriteria(Book.class)
                .add(Restrictions.eq("bookId", bookId))
                .list();
        return books;
    }

    public static List<Book> findByName(String bookName) {
        List<Book> books = new ArrayList<Book>();
        books = session.createCriteria(Book.class)
                .add(Restrictions.eq("bookName", bookName))
                .list();
        return books;
    }

    public static boolean deleteById(int bookId) {
        session.beginTransaction();
        Query query = session.createQuery("delete from Book where bookId = :id")
                .setParameter("id", bookId);
        query.executeUpdate();
        session.getTransaction().commit();

        query = session.createQuery("from Book where bookId = :id")
                .setParameter("id", bookId);
        List<Book> books = query.list();

        if (books == null || books.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean updateBook(Book book) {
        if (checkBook(book)) {
            session.beginTransaction();
            Book entityBook = session.get(Book.class, book.getBookId());
            copyBookObject(entityBook, book);
            session.update(entityBook);
            session.getTransaction().commit();
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
    public static int saveBook(Book book) {
        if (!checkBook(book)) {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            if (!checkBook(book)) return -1;
            else return 0;
        } else return 1;
    }

    private static boolean checkBook(Book book) {
        List<Book> books = new ArrayList<Book>();
        books = findById(book.getBookId());
        if (books == null || books.size() == 0){
            return false;
        }
        else {
            return true;
        }
    }

    private static void copyBookObject(Book entityBook, Book book){
        entityBook.setBookId(book.getBookId());
        entityBook.setBookName(book.getBookName());
        entityBook.setBookAuthor(book.getBookAuthor());
        entityBook.setNrOfPages(book.getNrOfPages());
    }
}
