package online.niuma.blog.vo.params;

import lombok.Data;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 *
 * 前端插入文章的请求参数包装
 */
@Data
public class ArticleParam {
    /**用户的id*/
    private Long userId;
    /**文章的标题*/
    private String articleTitle;
    /**文章的内容*/
    private String content;
}
