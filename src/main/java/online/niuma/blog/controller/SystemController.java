package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.pojo.Content;
import online.niuma.blog.pojo.Users;
import online.niuma.blog.utils.Constants;
import online.niuma.blog.vo.UserVo;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@Controller
public class SystemController {

    @GetMapping("/login")
    public String login() {
        log.info("request utl: /login");
        return "login";
    }

    @GetMapping({"/", "index"})
    public String index(Model model, HttpSession session) {
        log.info("request utl: / or /index");
        UserVo userInfo = (UserVo) session.getAttribute(Constants.USER_INFO);
        model.addAttribute(Constants.USER_INFO, userInfo);
        return "page/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(Constants.USER_INFO);
        return "login";
    }

    @GetMapping("/addArticle")
    public String toAddArticlePage(HttpSession session, Model model) {
        UserVo userInfo = (UserVo) session.getAttribute(Constants.USER_INFO);
        model.addAttribute(Constants.USER_INFO, userInfo);
        return "page/addArticle";
    }

}
