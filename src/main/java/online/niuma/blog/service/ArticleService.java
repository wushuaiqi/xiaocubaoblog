package online.niuma.blog.service;

import online.niuma.blog.pojo.Articles;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public interface ArticleService {

    /**
     * 调用添加文章
     * @param article 文章信息
     * @return 是否添加成功
     */
    boolean addArticle(Articles article);
}
