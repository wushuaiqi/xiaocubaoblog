package online.niuma.blog.vo.params;

import lombok.Data;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class ArticleParam {

    private Long userId;

    private String articleTitle;

    private String content;
}
