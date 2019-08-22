package com.at.guigu.servlet;

import com.at.guigu.dao.UserDao;
import com.at.guigu.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    UserDao dao = new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        boolean flag = dao.checkName(username);
        if (!flag){
            //用户已经存在
            request.setAttribute("message","用户已经存在,不能注册");
            //请求转发
            request.getRequestDispatcher("/jsp/regist.jsp").forward(request,response);
        }else{
            //重定向到登陆页面
            dao.insert(username,password,email);
            response.sendRedirect("/jsp/login.jsp");
        }

    }
}
