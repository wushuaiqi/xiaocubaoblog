package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.common.ErrorCode;
import online.niuma.blog.common.Result;
import online.niuma.blog.service.ArticleService;
import online.niuma.blog.utils.Constants;
import online.niuma.blog.utils.MyEmail;
import online.niuma.blog.vo.ContentVo;
import online.niuma.blog.vo.UserVo;
import online.niuma.blog.vo.params.ArticleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;
    private MyEmail myEmail;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setMyEmail(MyEmail myEmail) {
        this.myEmail = myEmail;
    }

    @PostMapping("/addArticle")
    public Result<String> addArticle(ArticleParam articleParam, HttpSession session) {
        log.info("come ArticleController execute addArticle function");
        boolean isCommit = this.articleService.addArticle(articleParam);
        if (isCommit) {
            UserVo userInfo = (UserVo) session.getAttribute(Constants.USER_INFO);
            String emailContent = "Ta 又开始想你啦！" + userInfo.getUserName() + "发布了主题为:《" + articleParam.getArticleTitle() + "》的思念，快去小醋包里查看吧。";
            log.info(myEmail.toString());
            myEmail.sendMail("小醋包系统", emailContent, userInfo.getToEmail());
            return Result.success("提交成功");
        } else {
            return Result.fail(ErrorCode.COMMIT_ERROR.getCode(), ErrorCode.COMMIT_ERROR.getMsg());
        }
    }

    @GetMapping("/getArticleById/{id}")
    public Result<ContentVo> getArticleInfoById(@PathVariable("id") String id) {
        log.info("request: /articles/getArticleById/{}", id);
        ContentVo userInfo = this.articleService.queryArticleOneById(id);
        return userInfo != null ? Result.success(userInfo) : Result.fail(ErrorCode.GET_ERROR.getCode(), ErrorCode.COMMIT_ERROR.getMsg());
    }
}
