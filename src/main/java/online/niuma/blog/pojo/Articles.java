package online.niuma.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class Articles {

    /**文章的 id*/
    private String articleId;

    /**文章的标题*/
    private String articleTitle;

    /**文章的摘要内容*/
    private String articleSketch;

    /**用户的 id 作者的 id*/
    private Long userId;

    /**文章内容的 id*/
    private String contentId;

    /**逻辑删除*/
    private int deleted;

    /**创建时间*/
    private Date createTime;

    /**修改时间*/
    private Date updateTime;
}
