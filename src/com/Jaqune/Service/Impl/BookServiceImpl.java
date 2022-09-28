package com.Jaqune.Service.Impl;

import com.Jaqune.Dao.BookDao;
import com.Jaqune.Dao.imp.BookDaoImpl;
import com.Jaqune.Service.BookService;
import com.Jaqune.bean.Book;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> getBookList() {

        try {
            return bookDao.selectBookList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeBook(Integer bookId) throws Exception {
        bookDao.deleteBook(bookId);
    }

    @Override
    public void saveBook(Book book) throws Exception {
        bookDao.insertBook(book);
    }

    @Override
    public Book getBookById(Integer bookId) throws Exception {
        return bookDao.selectBookByPrimaryKey(bookId);
    }

    @Override
    public void editBook(Book book) throws Exception {

        bookDao.updateBook(book);

    }
}
