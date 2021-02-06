package xyz.itclay.travel.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import xyz.itclay.travel.domain.ResultInfo;
import xyz.itclay.travel.domain.User;
import xyz.itclay.travel.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author ZhangSenmiao
 * @date 2021/2/6 13:33
 **/
@WebServlet("/user")
public class UserServlet extends BaseServlet {
    private final UserService userService=new UserService();

    /**
     * 注册方法
     *
     * @author ZhangSenmiao
     * @date 2021/2/6 13:38
     **/
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//        接收请求参数
            Map<String, String[]> map = req.getParameterMap();
//        封装User实体
            User user = new User();
            BeanUtils.populate(user, map);
//        调用service完成注册
            ResultInfo resultInfo = userService.register(user);
//        判断结果
            if (resultInfo.getSuccess()) {
                //            成功，重定向到成功页面
                resp.sendRedirect(req.getContextPath() + "/register_ok.jsp");
            } else {
                //            失败,将注册信息放到域中
                req.setAttribute("resultInfo", resultInfo);
                //            转发到注册页面
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
