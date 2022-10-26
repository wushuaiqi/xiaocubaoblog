package online.niuma.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class Content {

    private String contentId;

    private String contentText;

    private String articleId;

    private Date createTime;

    private Date updateTime;
}
