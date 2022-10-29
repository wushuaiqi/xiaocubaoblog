package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.service.ArticleService;
import online.niuma.blog.utils.Constants;
import online.niuma.blog.vo.ArticleVo;
import online.niuma.blog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    /**
     * 登陆页面访问请求
     * @return 登陆页面
     */
    @GetMapping("/login")
    public String login() {
        log.info("request utl: /login");
        return "login";
    }

    /**
     * 首页访问请求
     * todo 获取到用户和所有文章的信息存放 model
     * @return 首页
     */
    @GetMapping({"/", "index"})
    public String index(Model model, HttpSession session) {
        log.info("request utl: / or /index");
        // 从 session 中获取到登陆的用户的信息
        UserVo userInfo = (UserVo) session.getAttribute(Constants.USER_INFO);
        // 获取到所有的文章信息
        List<ArticleVo> articleInfoAll = this.articleService.getArticleInfoAll();
        // add user info to userInfo in model
        model.addAttribute(Constants.USER_INFO, userInfo);
        // add article info all to articles in model
        model.addAttribute("articles", articleInfoAll);
        return "page/index";
    }

    /**
     * 退出登陆请求
     * todo 从 session 删除用户的信息然后返回到登陆页面
     * @param session HttpSession
     * @return 登陆页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.info("request: /logout");
        // 从 session 中移除登陆是所设置的用户信息
        session.removeAttribute(Constants.USER_INFO);
        return "login";
    }

    /**
     * 新增文章页面请求
     * todo 从 session 中获取用户的信息存入 model
     * @param session HttpSession
     * @param model 容器
     * @return 新增文章页面
     */
    @GetMapping("/addArticle")
    public String toAddArticlePage(HttpSession session, Model model) {
        log.info("request: /addArticle");
        UserVo userInfo = (UserVo) session.getAttribute(Constants.USER_INFO);
        model.addAttribute(Constants.USER_INFO, userInfo);
        return "page/addArticle";
    }

    /**
     * 查看文章的访问页面请求
     * todo 获取到所要查看的文章 id,将其存入 model 中
     * @return article page
     */
    @GetMapping("articles/catArticle/{id}")
    public String toArticleContent(@PathVariable("id") String articleId, Model model) {
        log.info("request: /articles/catArticle/{}", articleId);
        model.addAttribute("articleId", articleId);
        return "page/content";
    }

}
