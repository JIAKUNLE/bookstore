package com.Jaqune.Sevlet.model;

import com.Jaqune.Service.BookService;
import com.Jaqune.Service.Impl.BookServiceImpl;
import com.Jaqune.Sevlet.base.ModelBaseServlet;
import com.Jaqune.bean.Book;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookManagerServlet extends ModelBaseServlet {
    private BookService bookService = new BookServiceImpl();

    public void toBookManagerPage(HttpServletRequest request,HttpServletResponse response) throws Exception {

        List<Book> bookList = bookService.getBookList();

        request.setAttribute("bookList",bookList);

        processTemplate("manager/book_manager",request,response);
    }
    public void removeBook(HttpServletRequest request,HttpServletResponse response) throws IOException{

        Integer id = Integer.valueOf(request.getParameter("id"));

        try {
            bookService.removeBook(id);

            response.sendRedirect(request.getContextPath()+"/bookManager?method=toBookManagerPage");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void toAddPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        processTemplate("manager/book_edit",request,response);
    }
    public void saveOrUpdateBook(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //1. 获取请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //2. 将parameterMap中的数据封装到Book对象
        try {
            Book book = new Book();
            BeanUtils.populate(book,parameterMap);

            //判断到底是修改还是添加
            if (book.getBookId() != null && !"".equals(book.getBookId())) {
                //修改图书信息
                bookService.editBook(book);
            }else {
                //添加图书信息
                //设置一个固定的imgPath
                book.setImgPath("static/uploads/xiaowangzi.jpg");
                //3. 调用业务层的方法保存图书信息
                bookService.saveBook(book);
            }

            //4. 保存成功，则重新查询所有图书
            response.sendRedirect(request.getContextPath()+"/bookManager?method=toBookManagerPage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toEditPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //获取客户端传入的id
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            //根据id查询图书详情
            Book book = bookService.getBookById(id);
            //将图书信息存储到请求域
            request.setAttribute("book",book);
            processTemplate("manager/book_edit",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
