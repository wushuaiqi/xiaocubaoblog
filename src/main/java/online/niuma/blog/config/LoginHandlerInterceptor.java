package online.niuma.blog.config;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.utils.Constants;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 验证 session 中是否有用户的信息
        // 如果有用户的信息则放行否则重定向到登陆页面
        log.info("come LoginHandlerInterceptor class execute preHandle()");
        Object userInfo = request.getSession().getAttribute(Constants.USER_INFO);
        if (userInfo == null) {
            log.warn("用户没有权限重定向到登陆页面");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        return true;
    }
}
