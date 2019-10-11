package com.lst.malls.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author :Nibelung
 * @Date ：Created in 10:27 2019/9/19
 * @Description :后台登录过滤器
 */
public class Loginfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    /**
     *
     * @param arg0
     * @param arg1
     * @param arg2
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        HttpSession session = request.getSession();

        final String uri = request.getRequestURI().startsWith("/") ? request.getRequestURI().substring(1) : request.getRequestURI();
        if (uri.contains(StaticUrl.PAGE_INDEX) || uri.contains(StaticUrl.PAGE_LOGIN)){
            //白名单
            arg2.doFilter(arg0, arg1);
            return;
        }
        if(session.getAttribute(StaticUrl.ADMIN)==null&& !request.getRequestURI().contains(StaticUrl.ADMIN_LOGIN)){
            // 没有登录
            response.sendRedirect("/page/back/login.jsp");
        }else{
            // 已经登录，继续请求下一级资源（继续访问）
            arg2.doFilter(arg0, arg1);
        }



    }




    @Override
    public void destroy() {

    }
}
