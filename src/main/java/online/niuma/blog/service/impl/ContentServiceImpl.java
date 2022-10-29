package online.niuma.blog.service.impl;

import online.niuma.blog.mapper.ContentMapper;
import online.niuma.blog.pojo.Content;
import online.niuma.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Service
public class ContentServiceImpl implements ContentService {

    private ContentMapper contentMapper;

    @Autowired
    public void setContentMapper(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

    /**
     * 调用持久层的接口所对应的方法将文章的内容数据插入到数据库中
     * @param content 文章的主要内容
     * @return 如果 i 大于 0 则表示插入成功
     */
    @Override
    public boolean addContent(Content content) {
        int i = this.contentMapper.addContent(content);
        return i != 0;
    }
}
