package online.niuma.blog.service;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.pojo.Articles;
import online.niuma.blog.vo.ArticleVo;
import online.niuma.blog.vo.params.ArticleParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public boolean addArticle(ArticleParam articleParam) {
        log.info("execute addArticle() function");
        Articles article = new Articles();
        BeanUtils.copyProperties(articleVo, article);
        System.out.println("article = " + article);
        return false;
    }
}
