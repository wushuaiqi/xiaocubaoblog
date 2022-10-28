package online.niuma.blog.dto;

import lombok.Data;
import online.niuma.blog.pojo.Users;

import java.util.Date;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class ArticleDto {

    private String articleId;

    private String articleTitle;

    private String articleSketch;

    private String userName;

    private Date createTime;
}
