package online.niuma.blog.service;

import online.niuma.blog.pojo.Articles;
import online.niuma.blog.vo.ArticleVo;
import online.niuma.blog.vo.ContentVo;
import online.niuma.blog.vo.params.ArticleParam;

import java.util.List;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public interface ArticleService {

    /**
     * 添加文章信息
     * @param articleParam 文章信息
     * @return 是否添加成功
     */
    boolean addArticle(ArticleParam articleParam);

    /**
     * 获取所有的文章信息
     * @return 所有的文章信息
     */
    List<ArticleVo> getArticleInfoAll();

    /**
     * 根据文章的id查询文章的信息
     * @param articleId 文章 id
     * @return 查询到的文章信息
     */
    ContentVo queryArticleOneById(String articleId);
}
