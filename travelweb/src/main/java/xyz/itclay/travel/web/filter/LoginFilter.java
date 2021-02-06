package xyz.itclay.travel.web.filter;

import xyz.itclay.travel.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录认证的过滤器
 *
 * @author ZhangSenmiao
 * @date 2021/1/26 21:42
 **/

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
         *对象转换
         *
         *放行的条件：session中去找登录者的信息，如果有值，则表明登录过，如果为null，表示还没有登录
         *          不必要的资源放行：登录页面，静态资源，登录方法等.....
         *
         * 获取session对象
         * 从session取出user，判断user是否为空
         **/
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        String substring = uri.substring(uri.lastIndexOf("/"));
        if ("/login.html".equals(substring) || "/login".equals(substring)) {
            filterChain.doFilter(req, resp);
            System.out.println("放行了login.html");
            return;
        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            filterChain.doFilter(req, resp);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    @Override
    public void destroy() {

    }
}
