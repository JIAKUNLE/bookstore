package com.Jaqune.Sevlet.model;

import com.Jaqune.Service.BookService;
import com.Jaqune.Service.Impl.BookServiceImpl;
import com.Jaqune.Sevlet.base.ViewBaseServlet;
import com.Jaqune.bean.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class PortalServlet extends ViewBaseServlet {


    private BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //查询动态数据
            List<Book> bookList = bookService.getBookList();
            //将动态数据存储到请求域
            request.setAttribute("bookList",bookList);
            processTemplate("index",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
