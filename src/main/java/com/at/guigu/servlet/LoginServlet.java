package com.at.guigu.servlet;

import com.at.guigu.bean.User;
import com.at.guigu.dao.UserDao;
import com.at.guigu.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    UserDao dao = new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = dao.checkNameAndPassword(username, password);
        HttpSession session = request.getSession();

        if (user != null) {
            //用户存在登录成功，重定向
            //将管理员信息放置在session域中
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/GetAllEmployeeServlet");
        }else {
            //请求转发到登陆页面
            request.setAttribute("message","账号名或者错误，无法登陆");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            //System.out.println(request.getAttribute("message"));
        }

    }
}
