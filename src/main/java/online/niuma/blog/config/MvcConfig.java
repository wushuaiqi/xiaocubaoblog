package online.niuma.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置不拦截的请求
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.do", "/login", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }
}
