package com.lst.malls.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author :Nibelung
 * @Date ：Created in 10:27 2019/9/19
 * @Description :
 * @Modified By :
 * @Version : $
 */
public class Loginfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        HttpSession session = request.getSession();

        final String uri = request.getRequestURI().startsWith("/") ? request.getRequestURI().substring(1) : request.getRequestURI();
        if (uri.contains("page/index.jsp") || uri.contains("page/back/login.jsp")){
            //白名单
            arg2.doFilter(arg0, arg1);
            return;
        }
        if(session.getAttribute("admin")==null&& request.getRequestURI().indexOf("/back/admin_login") == -1){
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
