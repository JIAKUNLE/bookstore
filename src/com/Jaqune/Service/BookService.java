package com.Jaqune.Service;

import com.Jaqune.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList() throws Exception;




    void removeBook(Integer bookId) throws Exception;


    void saveBook(Book book) throws Exception;



    Book getBookById(Integer bookId) throws Exception;


    void editBook(Book book) throws Exception;
}
