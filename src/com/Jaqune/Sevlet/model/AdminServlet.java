package com.Jaqune.Sevlet.model;

import com.Jaqune.Sevlet.base.ModelBaseServlet;

import javax.servlet.http.*;
import java.io.IOException;

public class AdminServlet extends ModelBaseServlet {

    public void toManagerPage(HttpServletRequest request,HttpServletResponse response) throws IOException {

        processTemplate("manager/manager",request,response);
    }
}
