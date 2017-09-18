package com.valerastudy.BookApp.model;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private int nrOfPages;

    public Book() {
    }

    public Book(int bookId, String bookName, String bookAuthor, int nrOfPages) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.nrOfPages = nrOfPages;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getNrOfPages() {
        return nrOfPages;
    }

    public void setNrOfPages(int nrOfPages) {
        this.nrOfPages = nrOfPages;
    }
}
