package com.at.guigu.servlet;

import com.at.guigu.bean.Employee;
import com.at.guigu.dao.EmplolyeeDao;
import com.at.guigu.dao.impl.EmplolyeeDaoImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetEmployeeByAjax")
public class GetEmployeeByAjax extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        EmplolyeeDao emplolyeeDao = new EmplolyeeDaoImpl();
        List<Employee> employee = emplolyeeDao.getEmployee();
        Gson gson = new Gson();
        String string = gson.toJson(employee);
        response.getWriter().write(string);
    }
}
