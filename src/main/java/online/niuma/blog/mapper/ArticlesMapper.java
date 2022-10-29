package online.niuma.blog.mapper;

import online.niuma.blog.dto.ArticleDto;
import online.niuma.blog.dto.ContentDto;
import online.niuma.blog.pojo.Articles;
import online.niuma.blog.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Mapper
@Repository
public interface ArticlesMapper {

    /**
     * 向数据库的 tb_articles 表中插入信息
     * article_id 文章的 id
     * article_title 文章的标题
     * article_sketch 文章的摘要内容
     * user_id 用户的 id 也就是作者的id
     * content_id 文章内容的 id
     * create_time 文章创建的时间
     * update_time 文章更新的时间
     * @param article 文章的信息
     * @return 执行 SQL 后所影响的行数
     */
    int addArticle(Articles article);

    /**
     * 在 tb_articles 表中查询所有文章所指定的信息
     * article_id 文章的 id
     * article_title 文章的标题
     * article_sketch 文章的摘要内容
     * user_name 作者的名字
     * create_time 创建的时间
     * @return 所有的文章信息
     */
    List<ArticleDto> queryArticleAll();

    /**
     * 以 tb_articles 表为主表根据文章 id 查询文章的信息和内容
     * article_id 文章的 id
     * content_id 文章内容的 id
     * article_title 文章的标题
     * content_text 文章的内容
     * user_name 作者的名字
     * create_time 文章创建的时间
     * @param articleId 文章 id
     * @return 在数据库中查询出来的文章的信息
     */
    ContentDto queryArticleOne(@Param("articleId") String articleId);
}
