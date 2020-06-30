package com.xiaoguo.Servlet;

import com.xiaoguo.dao.UserDao;
import com.xiaoguo.dao.impl.UserDaoImpl;
import com.xiaoguo.model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerServlet.do" )
public class RegisterServlet extends HttpServlet {
	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		request.setCharacterEncoding("UTF-8");
		//从request中获取客户端提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	    String email =  request.getParameter("email");
	    String sex = request.getParameter("sex");
		
		//将从客户端获得的数据封装到User对象中
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setSex(sex);
		//调用底层处理类中的处理方法进行功能处理
		UserDao userDao = new UserDaoImpl();
		int num = userDao.addUser(user);
		if(num>0){
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("register.jsp");
		}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}