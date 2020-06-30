package com.xiaoguo.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/addMessServlet.do/*"})//表示addMessServlet.do进行拦截
public class UserFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
    /***
     * 	当用户在添加评论时，验证用户是否已登录，如果未登录则直接跳转到login页面进行登录
     */
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
            throws IOException, ServletException {
        //将ServletRequest和ServletResponse转换为基于Http协议的ServletRequest和ServletResponse
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        //获得HttpSession对象
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null) {//用户未登录
            String path = request.getContextPath();
            response.sendRedirect(path+"/login.jsp");
            return;//当前方法结束
        }
        //继续原来的请求
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}
