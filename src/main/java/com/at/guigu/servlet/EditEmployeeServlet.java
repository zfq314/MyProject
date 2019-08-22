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

@WebServlet(name = "EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        EmplolyeeDao emplolyeeDao = new EmplolyeeDaoImpl();
        Employee emploee = emplolyeeDao.findEmploee(Integer.parseInt(id));
        if (emploee != null) {
            request.setAttribute("emp",emploee);
            request.getRequestDispatcher("/jsp/edit.jsp").forward(request,response);
        }

    }
}
