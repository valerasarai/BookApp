package com.valerastudy.BookApp;

import com.valerastudy.BookApp.database.DbImpl;
import com.valerastudy.BookApp.model.Book;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DbImplTest {
    Book book = new Book(1,"Book 1","Author 1", 200);

    @Test
    public void test01_saveBookTest() {
        Assert.assertEquals(true, (DbImpl.saveBook(book) >= 0));
    }

    @Test
    public void test02_updateBookTest(){
        book.setNrOfPages(10);
        Assert.assertEquals(true, DbImpl.updateBook(book));
    }

    @Test
    public void test03_deleteById(){
        book.setBookId(2);
        DbImpl.saveBook(book);
        Assert.assertEquals(true, DbImpl.deleteById(book.getBookId()));
    }

    private static String bookToString(Book book){
        return "Book info {bookId = '" + book.getBookId()
                + "', bookName = '" + book.getBookName()
                + "', bookAuthor = '" + book.getBookAuthor()
                + "', nrOfPages = '" + book.getNrOfPages()
                + "'}";
    }

}
