package com.valerastudy.BookApp.bo.impl;

import com.valerastudy.BookApp.bo.BookBo;
import com.valerastudy.BookApp.dao.BookDao;
import com.valerastudy.BookApp.model.Book;

import java.util.List;

public class BookBoImpl implements BookBo {

    BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findById(int bookId) {
        return bookDao.findById(bookId);
    }

    public List<Book> findByName(String bookName) {
        return bookDao.findByName(bookName);
    }

    public boolean deleteById(int bookId) {
        return bookDao.deleteById(bookId);
    }

    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    public boolean saveBook(Book book) {
        return bookDao.saveBook(book);
    }
}
