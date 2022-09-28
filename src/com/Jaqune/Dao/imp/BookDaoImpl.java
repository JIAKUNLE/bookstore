package com.Jaqune.Dao.imp;

import com.Jaqune.Dao.BaseDao;
import com.Jaqune.Dao.BookDao;
import com.Jaqune.bean.Book;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> selectBookList() throws SQLException{
        String sql = "select book_id bookId,book_name bookName,author,price,sales,stock,img_path imgPath from t_book";

        return getBeanList(sql, Book.class);
    }

    @Override
    public void deleteBook(Integer bookId) throws SQLException {

        String sql="delete from t_book where book_id = ? ";

        update(sql,bookId);

    }

    @Override
    public void insertBook(Book book) throws SQLException {
        String sql = "insert into t_book (book_name,author,price,sales,stock,img_path) values (?,?,?,?,?,?)";
        update(sql,book.getBookName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());

    }

    @Override
    public Book selectBookByPrimaryKey(Integer bookId) throws SQLException {
        String sql = "select book_id bookId,book_name bookName,author,price,sales,stock,img_path imgPath from t_book where book_id=?";

        return getBean(sql,Book.class,bookId);
    }

    @Override
    public void updateBook(Book book) throws SQLException {

        String sql = "update t_book set book_name=?,price=?,author=?,sales=?,stock=? where book_id=?";

        update(sql,book.getBookName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getBookId());

    }
}
