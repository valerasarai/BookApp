package com.valerastudy.BookApp.dao.impl;

import com.valerastudy.BookApp.database.DbImpl;
import com.valerastudy.BookApp.model.Book;
import com.valerastudy.BookApp.dao.BookDao;

import java.util.List;

public class BookDaoImpl implements BookDao {

    private DbImpl db = new DbImpl();

    public List<Book> findAll() {
        return db.findAll();
    }

    public Book findById(int bookId) {
        return db.findById(bookId);
    }

    public Book findByName(String bookName) {
        return db.findByName(bookName);
    }

    public boolean deleteById(int bookId) {
        return db.deleteById(bookId);
    }

    public boolean updateBook(Book book) {
        return updateBook(book);
    }

    public int saveBook(Book book) {
        return db.saveBook(book);
    }

    public int getMaxId(){
        return db.getMaxId();
    }
}
