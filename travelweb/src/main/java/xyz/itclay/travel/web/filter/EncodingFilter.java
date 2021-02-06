package xyz.itclay.travel.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决post中文乱码过滤器
 *
 * @author ZhangSenmiao
 * @date 2021/1/26 21:58
 **/
//@WebFilter(value = "/*", initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class EncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        System.out.println(encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
         *对象转换
         *设置编码格式
         *放行
         **/
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset=" + encoding);

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
