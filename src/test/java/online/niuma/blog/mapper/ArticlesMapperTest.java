package online.niuma.blog.mapper;

import online.niuma.blog.dto.ArticleDto;
import online.niuma.blog.pojo.Articles;
import online.niuma.blog.vo.ArticleVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@SpringBootTest
class ArticlesMapperTest {

    @Autowired
    ArticlesMapper articlesMapper;

    @Test
    void addArticle() {
        String articleId = UUID.randomUUID().toString();
        String articleTitle = "test title 1";
        String articleSketch = "niuma";
        Long userId = 1L;
        String contentId = "1";
        Date createTime = new Date();
        Date updateTime = new Date();
        Articles article = new Articles();
        article.setArticleId(articleId);
        article.setArticleTitle(articleTitle);
        article.setArticleSketch(articleSketch);
        article.setUserId(userId);
        article.setContentId(contentId);
        article.setCreateTime(createTime);
        article.setUpdateTime(updateTime);
        System.out.println("article.toString() = " + article.toString());
        int i = this.articlesMapper.addArticle(article);
        System.out.println(i);
    }

    @Test
    void queryArticleAll() {
        List<ArticleVo> articles = this.articlesMapper.queryArticleAll();
        for (ArticleVo article : articles) {
            System.out.println(article);
        }
    }
}