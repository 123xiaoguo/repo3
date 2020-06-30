package com.xiaoguo.Servlet;

import com.xiaoguo.dao.MessDao;
import com.xiaoguo.dao.impl.MessDaoImpl;
import com.xiaoguo.model.Mess;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.xiaoguo.model.User;

@WebServlet("/addMessServlet.do")
public class addMessServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置编码集
        request.setCharacterEncoding("UTF-8");
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        String mess_text = request.getParameter("mess_text");
        Mess mess = new Mess();
        mess.setCommentID(commentId);
        mess.setMess_text(mess_text);
        //从session获取user属性
        User user = (User) request.getSession().getAttribute("user");
         int userId = 0;
        if(user!=null){
            userId=user.getUserID();
        }
        mess.setUserID(userId);
        MessDao messDao = new MessDaoImpl();
        int num = messDao.addMess(mess);
        //根据处理结果进行页面跳转
        if (num > 0) {
            //跳转到queryBookByIDServlet
            response.sendRedirect("queryById.do?commentId=" + commentId);

        } else {
            //跳转到queryBookByIDServlet
            response.sendRedirect("queryById.do?commentId=" + commentId);
        }
        }
}
