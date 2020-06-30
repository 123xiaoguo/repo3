package com.xiaoguo.Servlet;

import com.xiaoguo.dao.AdminDao;
import com.xiaoguo.dao.impl.AdminDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteUser.do")
public class deleteUserServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int userId = Integer.parseInt(request.getParameter("userID"));
        AdminDao adminDao = new AdminDaoImpl();
        adminDao.deleteUser(userId);
        response.sendRedirect(request.getContextPath()+"/queryUser.do");
    }
}
