package online.niuma.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class Content {

    /**文章的 id*/
    private String contentId;

    /**文章的内容*/
    private String contentText;

    /**文章的 id*/
    private String articleId;

    /**创建的时间*/
    private Date createTime;

    /**修改的时间*/
    private Date updateTime;
}
