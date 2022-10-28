package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.common.ErrorCode;
import online.niuma.blog.common.Result;
import online.niuma.blog.service.ArticleService;
import online.niuma.blog.vo.ContentVo;
import online.niuma.blog.vo.params.ArticleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/addArticle")
    public Result<String> addArticle(ArticleParam articleParam) {
        log.info("come ArticleController execute addArticle function");
        boolean isCommit = this.articleService.addArticle(articleParam);
        if (isCommit) {
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
