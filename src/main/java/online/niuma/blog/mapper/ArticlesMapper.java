package online.niuma.blog.mapper;

import online.niuma.blog.dto.ArticleDto;
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

    List<ArticleVo> queryArticleAll();
}
