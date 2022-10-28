package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.pojo.Content;
import online.niuma.blog.pojo.Users;
import online.niuma.blog.service.ArticleService;
import online.niuma.blog.utils.Constants;
import online.niuma.blog.vo.ArticleVo;
import online.niuma.blog.vo.UserVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@Controller
public class SystemController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/login")
    public String login() {
        log.info("request utl: /login");
        return "login";
    }

    /**
     * to index page
     */
    @GetMapping({"/", "index"})
    public String index(Model model, HttpSession session) {
        log.info("request utl: / or /index");
        UserVo userInfo = (UserVo) session.getAttribute(Constants.USER_INFO);
        List<ArticleVo> articleInfoAll = this.articleService.getArticleInfoAll();
        model.addAttribute(Constants.USER_INFO, userInfo);
        model.addAttribute("articles", articleInfoAll);
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
