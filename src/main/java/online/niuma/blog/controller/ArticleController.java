package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.common.Result;
import online.niuma.blog.vo.params.ArticleParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @PostMapping("/addArticle")
    public Result<String> addArticle(@RequestBody ArticleParam articleParam) {
        log.info("come ArticleController execute addArticle function");
        System.out.println("articleParam = " + articleParam);
        return null;
    }
}
