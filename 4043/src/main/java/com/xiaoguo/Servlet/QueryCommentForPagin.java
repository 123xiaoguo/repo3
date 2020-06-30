package com.xiaoguo.Servlet;

import com.xiaoguo.model.PageInfo;
import com.xiaoguo.model.PageParams;
import com.xiaoguo.service.CommentService;
import com.xiaoguo.service.Impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
@WebServlet("/query.do")
public class QueryCommentForPagin extends HttpServlet{
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        //待查询页码的默认值
        int pageNum = 1;
        //从客户端传入的页码
        String pageNumStr = request.getParameter("pageNum");
        if(pageNumStr!=null&&!pageNumStr.equals("")){
            try{
                pageNum = Integer.parseInt(pageNumStr);
            }catch (NumberFormatException e){
                e.printStackTrace();
                pageNum=1;
            }
        }

        //创建commentService对象
        CommentService commentService = new CommentServiceImpl();
        //创建一个PageParams对象
        PageParams pageParams = new PageParams(pageNum,4);
        //调用service
        PageInfo pageInfo = commentService.queryCommentForPagin(pageParams);
        //当前页
        request.setAttribute("currPageNum",pageInfo.getCurPageNum());
        //计算总页数
        int countPage =
                pageInfo.getCountRow()%pageParams.getPageRowNum()==0?
                        pageInfo.getCountRow() / pageParams.getPageRowNum():
                        pageInfo.getCountRow() / pageParams.getPageRowNum()+1;
        System.out.println(countPage);
        System.out.println(pageInfo.getCountRow());
        System.out.println(pageInfo.getCurPageNum());
        //将总页数存入到request对象中
        request.setAttribute("countPage", countPage);
        //将数据添加到request对象中
        request.setAttribute("comments", pageInfo.getData());
        // 请求转发到页面
        request.getRequestDispatcher("showComments.jsp").forward(request, response);
    }
}
