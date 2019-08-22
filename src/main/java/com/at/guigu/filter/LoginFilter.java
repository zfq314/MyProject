package com.at.guigu.filter;

import com.at.guigu.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            chain.doFilter(req, resp);
        }else {
            request.setAttribute("message","进行此操作之前需要先登录");
            request.getRequestDispatcher(request.getContextPath() + "/jsp/login.jsp").forward(request,resp);
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
