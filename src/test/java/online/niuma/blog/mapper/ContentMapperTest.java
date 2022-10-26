package online.niuma.blog.mapper;

import online.niuma.blog.pojo.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@SpringBootTest
class ContentMapperTest {

    @Autowired
    ContentMapper contentMapper;

    @Test
    void addContent() {
        String contentId = UUID.randomUUID().toString();
        String articleId = "9690a6e9-f384-46fa-a5a7-a5783c37a42c";
        Content content = new Content();
        content.setContentId(contentId);
        content.setContentText("test content");
        content.setArticleId(articleId);
        content.setCreateTime(new Date());
        content.setUpdateTime(new Date());
        int i = this.contentMapper.addContent(content);
        System.out.println(i > 0 ? "yes" : "no");
    }
}