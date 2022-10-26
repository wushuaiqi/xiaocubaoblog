package online.niuma.blog.service.impl;

import online.niuma.blog.service.ArticleService;
import online.niuma.blog.vo.params.ArticleParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    ArticleService articleService;

    @Test
    void addArticle() {
        ArticleParam articleParam = new ArticleParam();
        articleParam.setUserId(1L);
        articleParam.setArticleTitle("test");
        articleParam.setContent("以上就是关于“Java截取字符串的函数的方式”介绍，大家如果对此比较感兴趣，想了解更多相关知识，可以来看看动力节点的字符串截取的4种方式，相信对大家的学习会有所帮助的。");
        boolean b = this.articleService.addArticle(articleParam);
        System.out.println(b ? "yes" : "no");
    }
}