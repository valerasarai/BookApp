package com.valerastudy.BookApp.dao;

import com.valerastudy.BookApp.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    List<Book> findById(int bookId);
    List<Book> findByName(String bookName);
    boolean deleteById(int bookId);
    boolean updateBook(Book book);
    boolean saveBook(Book book);
}
