package online.niuma.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class Articles {

    private String articleId;

    private String articleTitle;

    private String articleSketch;

    private Long userId;

    private Long contentId;

    private int deleted;

    private Date createTime;

    private Date updateTime;
}
