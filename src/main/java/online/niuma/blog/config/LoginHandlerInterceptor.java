package online.niuma.blog.config;

import online.niuma.blog.utils.Constants;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Object userInfo = request.getSession().getAttribute(Constants.USER_INFO);
        //if (userInfo == null) {
        //    request.getRequestDispatcher("/login").forward(request, response);
        //    return false;
        //}
        return true;
    }
}
