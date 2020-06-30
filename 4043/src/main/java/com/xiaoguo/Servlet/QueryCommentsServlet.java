package com.xiaoguo.Servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xiaoguo.dao.CommentDao;
import com.xiaoguo.dao.impl.CommentDaoImpl;
import com.xiaoguo.model.Comment;
@WebServlet("/queryComments.do")
public class QueryCommentsServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentDao commentDao = new CommentDaoImpl();
		//调用获取留言的方法获取
		List<Comment> comments = commentDao.queryComment();
		//判断是否获取倒留言
		if(comments!=null && comments.size()!=0) {
            //将留言存入到request对象中，通过请求转发将request对象发送到页面展示
            request.setAttribute("comments", comments);
            //请求转发到页面
			request.getRequestDispatcher("showComments.jsp").forward(request, response);
		}
	}
	
}
