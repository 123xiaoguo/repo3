package com.xiaoguo.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoguo.dao.UserDao;
import com.xiaoguo.dao.impl.UserDaoImpl;
import com.xiaoguo.model.User;


@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//从request中获取客户端提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        //调用底层处理类中的处理方法进行功能处理
		UserDao userDao = new UserDaoImpl();
		User user = userDao.login(username, password);

		if(user!=null){
			//登录成功将user对象添加倒session
			request.getSession().setAttribute("user", user);
			//获得根路径
			String path = request.getServletContext().getContextPath();
			response.sendRedirect(path);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);}
	}

}
