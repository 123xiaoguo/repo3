package com.xiaoguo.Servlet;

import com.xiaoguo.dao.AdminDao;
import com.xiaoguo.dao.impl.AdminDaoImpl;
import com.xiaoguo.model.Admin;
import com.xiaoguo.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryUser.do")
public class queryUserServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDao adminDao = new AdminDaoImpl();
        //调用获取留言的方法获取
        List<User> users = adminDao.queryUser();
        //判断是否获取倒留言
        if(users!=null && users.size()!=0) {
            //将留言存入到request对象中，通过请求转发将request对象发送到页面展示
            request.setAttribute("users", users);
            //请求转发到页面
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }
}
