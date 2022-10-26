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
     * 在数据库中添加文章内容信息
     * @param content 文章内容信息
     * @return 受影响的行数
     */
    int addContent(Content content);
}
