package com.xiaoguo.Servlet;

import com.xiaoguo.dao.AdminDao;
import com.xiaoguo.dao.impl.AdminDaoImpl;
import com.xiaoguo.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/queryUserById.do")
public class queryUserByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int userId = Integer.parseInt(request.getParameter("userID"));
        AdminDao adminDao = new AdminDaoImpl();
        User user = adminDao.findById(userId);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
