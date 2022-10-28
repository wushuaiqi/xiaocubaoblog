package online.niuma.blog.vo;

import lombok.Data;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class ContentVo {
    private String articleId;
    private String contentId;
    private String articleTitle;
    private String contentText;
    private String userName;
    private String createTime;
}
