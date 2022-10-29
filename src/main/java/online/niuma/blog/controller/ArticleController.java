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

    /**
     * 添加文章的 http 请求
     * 调用 Service 层接口的相关方法对文章进行存储
     * todo 如果存储成功后对相关联的用户邮箱发送提醒邮件
     * @param articleParam 文章请求信息的封装类
     * @param session HttpSession
     * @return 如果成功则返回成功的消息，否则返回错误信息
     */
    @PostMapping("/addArticle")
    public Result<String> addArticle(ArticleParam articleParam, HttpSession session) {
        log.info("request: /addArticle");
        log.info("come ArticleController execute addArticle function");
        boolean isCommit = this.articleService.addArticle(articleParam);
        // 如果文章的内容储存成功了则向其关联的邮箱发送邮件
        if (isCommit) {
            // 从HttpSession 中获取到用户的信息
            UserVo userInfo = (UserVo) session.getAttribute(Constants.USER_INFO);
            // 定义邮件发送的内容
            String emailContent = "Ta 又开始想你啦！" + userInfo.getUserName() + "发布了主题为:《" +
                    articleParam.getArticleTitle() + "》的思念，快去小醋包里查看吧。";
            // 盗用定义好的邮件发送组件发送邮件
            // 异步发送
            myEmail.sendMail("小醋包系统", emailContent, userInfo.getToEmail());
            return Result.success("提交成功");
        } else {
            return Result.fail(ErrorCode.COMMIT_ERROR.getCode(), ErrorCode.COMMIT_ERROR.getMsg());
        }
    }

    /**
     * 查询单个文章的请求
     * todo 根据文章的 id 获取到文章的信息
     * @param id 文章的 id
     * @return 如果查询到文章返回成功和文章的信息否则返回错误信息
     */
    @GetMapping("/getArticleById/{id}")
    public Result<ContentVo> getArticleInfoById(@PathVariable("id") String id) {
        log.info("request: /articles/getArticleById/{}", id);
        ContentVo userInfo = this.articleService.queryArticleOneById(id);
        return userInfo != null ? Result.success(userInfo) : Result.fail(ErrorCode.GET_ERROR.getCode(),
                ErrorCode.COMMIT_ERROR.getMsg());
    }
}
