package online.niuma.blog.service;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.pojo.Articles;
import org.springframework.stereotype.Service;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public boolean addArticle(Articles article) {
        log.info("execute addArticle() function");
        return false;
    }
}
