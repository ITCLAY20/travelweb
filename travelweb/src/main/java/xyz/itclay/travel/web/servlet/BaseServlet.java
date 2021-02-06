package xyz.itclay.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author ZhangSenmiao
 * @date 2021/1/26 21:17
 **/
public class BaseServlet extends HttpServlet {

    /*
     * 1.获取uri
     * 2.获取执行的方法名
     * 3.获取Method对象(反射)
     *  3.1.方法名
     *  3.2 参数列表
     *  3.3 方法所在的对象this
     * 4.暴力反射
     * 5.执行this对象上带有req和resp的method方法
     **/

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String substring = uri.substring(uri.lastIndexOf("/") + 1);
        String action = req.getParameter("action");
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
