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
     * 插入文章的信息
     * @param article 文章的信息
     * @return 受影响的行数
     */
    int addArticle(Articles article);

    /**
     * 查询所有的文章信息
     * 查询文章的标题、简介、作则、创建时间
     * @return 所有的文章信息
     */
    List<ArticleDto> queryArticleAll();

    /**
     * 根据文章 id 查询文章的信息和内容
     * @param articleId 文章 id
     * @return 文章的信息和内容
     */
    ContentDto queryArticleOne(@Param("articleId") String articleId);
}
