package com.valerastudy.BookApp.dao;

import com.valerastudy.BookApp.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book findById(int bookId);
    Book findByName(String bookName);
    boolean deleteById(int bookId);
    boolean updateBook(Book book);
    int saveBook(Book book);
}
