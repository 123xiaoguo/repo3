package com.xiaoguo.Servlet;

import com.xiaoguo.model.Comment;
import com.xiaoguo.model.Mess;
import com.xiaoguo.service.CommentService;
import com.xiaoguo.service.Impl.CommentServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryById.do")
public class QueryByIdServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		//调用底层处理类
		CommentService commentService = new CommentServiceImpl();
		//调用commentService对象中的查询方法，根据commentId获得留言信息
		Map<Comment,List<Mess>> commentListMap = commentService.queryCommentById(commentId);
		//遍历map集合，并将key和value都存入到request对象中
		for(Map.Entry<Comment, List<Mess>> entry:commentListMap.entrySet()) {
			//3.将得到的图书信息存入到request对象中
			request.setAttribute("comment", entry.getKey());
			request.setAttribute("messList", entry.getValue());
		}
       //请求转发到addComment.jsp页面进行展示
		request.getRequestDispatcher("addComment.jsp").forward(request, response);
	}
}
