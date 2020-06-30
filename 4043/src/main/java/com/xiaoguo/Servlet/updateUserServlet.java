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
import java.util.Map;

@WebServlet("/update.do")
public class updateUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//       User user = (User) request.getSession().getAttribute("user");
//       if(user!=null){
         int userId = Integer.parseInt(request.getParameter("userID"));
           //从request中获取客户端提交的数据
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           String sex = request.getParameter("sex");
           String email =  request.getParameter("email");
            User user = new User();
           user.setUserID(userId);
           user.setUserName(username);
           user.setPassword(password);
           user.setSex(sex);
           user.setEmail(email);
           AdminDao adminDao = new AdminDaoImpl();
              adminDao.update(user);
              response.sendRedirect(request.getContextPath()+"/queryUser.do");
       }

}
