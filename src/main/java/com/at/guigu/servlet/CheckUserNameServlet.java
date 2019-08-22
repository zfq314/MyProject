package com.at.guigu.servlet;

import com.at.guigu.dao.UserDao;
import com.at.guigu.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkUsername")
public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserDao userDao  = new UserDaoImpl();
        System.out.println(username);
        boolean b = userDao.checkName(username);
        System.out.println(b);
        String msg;
        if (b){
            msg = "用户名可用";
        }else{
            msg = "用户名已经存在，请更换";
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(msg);
    }
}
