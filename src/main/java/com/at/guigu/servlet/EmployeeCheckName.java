package com.at.guigu.servlet;

import com.at.guigu.bean.Employee;
import com.at.guigu.dao.EmplolyeeDao;
import com.at.guigu.dao.impl.EmplolyeeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeCheckName")
public class EmployeeCheckName extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastName = request.getParameter("lastName");
        EmplolyeeDao emplolyeeDao = new EmplolyeeDaoImpl();
        boolean flag = emplolyeeDao.exisName(lastName);
        response.setContentType("text/html;charset=UTF-8");
        if (flag){
            response.getWriter().write("名字可以使用");
        }else{
            response.getWriter().write("名字已经存在，请修改");
        }
    }
}
