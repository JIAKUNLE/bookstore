package com.Jaqune.Dao;

import com.Jaqune.bean.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao<T> {

    List<T> selectBookList() throws SQLException;


    void deleteBook(Integer bookId) throws SQLException;

    void insertBook(Book book) throws SQLException;


    Book selectBookByPrimaryKey(Integer bookId) throws SQLException;


    void updateBook(Book book) throws SQLException;
}
