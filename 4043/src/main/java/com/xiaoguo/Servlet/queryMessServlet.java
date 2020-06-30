package com.xiaoguo.Servlet;

import com.xiaoguo.dao.AdminDao;
import com.xiaoguo.dao.impl.AdminDaoImpl;
import com.xiaoguo.model.Admin;
import com.xiaoguo.model.Mess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryMess.do")
public class queryMessServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDao adminDao = new AdminDaoImpl();
        //调用获取留言的方法获取
        List<Mess> messes = adminDao.queryMess();
        //判断是否获取倒留言
        if(messes!=null && messes.size()!=0) {
            //将留言存入到request对象中，通过请求转发将request对象发送到页面展示
            request.setAttribute("messes", messes);
            //请求转发到页面
            request.getRequestDispatcher("admain.jsp").forward(request, response);
        }
    }
}
