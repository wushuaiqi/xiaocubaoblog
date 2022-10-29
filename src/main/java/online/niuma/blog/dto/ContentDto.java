package online.niuma.blog.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class ContentDto {

    /**
     *
     select
     a.article_id,
     a.content_id,
     a.article_title,
     c.content_text,
     u.user_name,
     a.create_time
     from xiaocubaoBlog_db.tb_articles a ,
     xiaocubaoBlog_db.tb_users u,
     xiaocubaoBlog_db.tb_content c
     where a.user_id = u.user_id
     and a.content_id = c.content_id
     and a.article_id = '1490a809-c053-4821-8214-3a356b9b5891'
     limit 1
     ;
     */

    private String articleId;
    private String contentId;
    private String articleTitle;
    private String contentText;
    private String userName;
    private Date createTime;
}
