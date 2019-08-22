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
import java.util.List;

@WebServlet(name = "GetAllEmployeeServlet")
public class GetAllEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        EmplolyeeDao emplolyeeDao = new EmplolyeeDaoImpl();
        List<Employee> employee = emplolyeeDao.getEmployee();
        request.setAttribute("emp",employee);
        //请求转发到一个新的页面
        request.getRequestDispatcher("/jsp/show.jsp").forward(request,response);
    }
}
