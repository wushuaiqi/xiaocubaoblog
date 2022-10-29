package online.niuma.blog.mapper;

import online.niuma.blog.pojo.Content;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Mapper
@Repository
public interface ContentMapper {

    /**
     * 在数据库 tb_content 中添加文章内容信息
     * content_id 文章内容的 id
     * content_text 文章内容主体
     * article_id 文章的 id
     * create_time 创建的时间
     * update_time 更新的时间
     * @param content 文章内容信息
     * @return 执行 SQL 后所影响的行数
     */
    int addContent(Content content);
}
