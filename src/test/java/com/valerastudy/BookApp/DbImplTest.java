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
    DbImpl db = new DbImpl();

   // @Test
    public void test01_saveBookTest() {

        int result = db.saveBook(book);
        System.out.println(result);
        Assert.assertEquals(true, (result >= 0));
    }

  //  @Test
    public void test02_updateBookTest(){
        book.setNrOfPages(10);
        Assert.assertEquals(true, db.updateBook(book));
    }

  //  @Test
    public void test03_deleteById(){
        book.setBookId(2);
        db.saveBook(book);
        Assert.assertEquals(true, db.deleteById(book.getBookId()));
    }

    //@Test
    public void test04_getMaxId() {

        int maxId = db.getMaxId();
        System.out.println(maxId);
        Assert.assertEquals(1, maxId);
    }

        private static String bookToString(Book book){
        return "Book info {bookId = '" + book.getBookId()
                + "', bookName = '" + book.getBookName()
                + "', bookAuthor = '" + book.getBookAuthor()
                + "', nrOfPages = '" + book.getNrOfPages()
                + "'}";
    }

}
