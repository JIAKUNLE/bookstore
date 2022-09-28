package com.Jaqune.Sevlet.model;

import com.Jaqune.Service.Impl.UserServiceImpl;
import com.Jaqune.Service.UserService;
import com.Jaqune.Sevlet.base.ModelBaseServlet;
import com.Jaqune.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class UserServlet extends ModelBaseServlet {
    private UserService userService = new UserServiceImpl();


    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        processTemplate("/user/login", request, response);
    }

    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(null, username, password, null);


        try {
            User loginUser = userService.checkLogin(user);

            request.getSession().setAttribute("loginUser", loginUser);
            processTemplate("/user/login_success", request, response);


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "登录失败！" + e.getMessage());
            processTemplate("/user/login", request, response);
        }


    }

    public void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();

        Map<String, String[]> parameterMap = request.getParameterMap();

        String code = parameterMap.get("code")[0];

        String checkCode = (String) request.getSession().getAttribute("checkCode");
        try {
            if (checkCode.equalsIgnoreCase(code)) {

                BeanUtils.populate(user, parameterMap);


                userService.checkRegist(user);
                processTemplate("user/regist_success", request, response);


            } else {
                throw new RuntimeException("验证码错误");
            }


        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("errorMessage", "注册失败" + e.getMessage());
            processTemplate("user/regist", request, response);


        }
    }

    public void toRegist(HttpServletRequest request, HttpServletResponse response) throws IOException{

        processTemplate("user/regist",request,response);


    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{

        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath() + "/index.html");

    }
}

