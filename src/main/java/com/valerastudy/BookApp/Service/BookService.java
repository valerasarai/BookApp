package com.valerastudy.BookApp.Service;

import com.valerastudy.BookApp.dao.impl.BookDaoImpl;
import com.valerastudy.BookApp.model.Book;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/BookService")
public class BookService {
    BookDaoImpl bookDao = new BookDaoImpl();
    private static final String SUCCESS_RESULT="<result>success</result>";
    private static final String FAILURE_RESULT="<result>failure</result>";

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    @GET
    @Path("/book/id/{bookId}")
    @Produces(MediaType.APPLICATION_XML)
    public Book findById(@PathParam("bookId")int bookId){
        return bookDao.findById(bookId);
    }

    @GET
    @Path("/book/name/{bookName}")
    @Produces(MediaType.APPLICATION_XML)
    public Book findByName(@PathParam("bookName")String bookName){
        return bookDao.findByName(bookName);
    }

    @POST
    @Path("/book")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateBook(@FormParam("bookId") int bookId,
                             @FormParam("bookName") String bookName,
                             @FormParam("bookAuthor") String bookAuthor,
                             @FormParam("nrOfPages") int nrOfPages,
                             @Context HttpServletResponse servletResponse) throws IOException {
        Book book = new Book(bookId, bookName, bookAuthor, nrOfPages);
        boolean result = bookDao.updateBook(book);
        if(result){
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @PUT
    @Path("/book")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createBook() {
        int maxId = bookDao.getMaxId();
        maxId++;
        Book book = new Book(maxId,
                "Book " + maxId,
                "Author " + maxId,
                (maxId * 2 / 3));
        int result = bookDao.saveBook(book);
        if(result >= 0){
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @DELETE
    @Path("/book/{bookId}")
    @Produces(MediaType.APPLICATION_XML)
    public String deleteBook(@PathParam("bookId") int bookId){
        boolean result = bookDao.deleteById(bookId);
        if(result){
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }
}
