package com.valerastudy.BookApp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
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

    @XmlElement
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    @XmlElement
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    @XmlElement
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getNrOfPages() {
        return nrOfPages;
    }

    @XmlElement
    public void setNrOfPages(int nrOfPages) {
        this.nrOfPages = nrOfPages;
    }

}
