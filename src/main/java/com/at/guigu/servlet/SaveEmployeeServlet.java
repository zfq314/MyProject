package com.at.guigu.servlet;

import com.at.guigu.dao.EmplolyeeDao;
import com.at.guigu.dao.impl.EmplolyeeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveEmployeeServlet")
public class SaveEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String salary = request.getParameter("salary");
        String dept = request.getParameter("dept");
        EmplolyeeDao emplolyeeDao = new EmplolyeeDaoImpl();
        int update = emplolyeeDao.saveEmployee(Integer.parseInt(id), lastName, email, Double.parseDouble(salary), dept);
        if (update == 1){
            //修改成功，跳转到显示列表
            request.getRequestDispatcher(request.getContextPath() + "/GetAllEmployeeServlet").forward(request,response);

        }
    }
}
