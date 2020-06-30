package com.xiaoguo.Servlet;

import com.xiaoguo.dao.AdminDao;
import com.xiaoguo.dao.impl.AdminDaoImpl;
import com.xiaoguo.model.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet.do")
public class LoginAdminServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //从request中获取客户端提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用底层处理类中的处理方法进行功能处理
       AdminService as=new AdminServiceImpl();
     Admin admin=as.login(username,password);
        if(admin!=null){
            //登录成功将admin对象添加倒session
            request.getSession().setAttribute("admin", admin);
            response.sendRedirect("findAllMessageServlet");
        }else{
            request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
        }
    }
}
