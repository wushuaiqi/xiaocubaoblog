package online.niuma.blog.service;

import online.niuma.blog.pojo.Articles;
import online.niuma.blog.vo.ArticleVo;
import online.niuma.blog.vo.params.ArticleParam;

import java.util.List;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public interface ArticleService {

    /**
     * 调用添加文章
     * @param articleParam 文章信息
     * @return 是否添加成功
     */
    boolean addArticle(ArticleParam articleParam);

    List<ArticleVo> getArticleInfoAll();
}
