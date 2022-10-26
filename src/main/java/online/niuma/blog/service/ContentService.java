package online.niuma.blog.service;

import online.niuma.blog.pojo.Content;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public interface ContentService {

    /**
     * 像数据库中插入文章的内容
     * @param content 文章的主要内容
     * @return 是否插入成功
     */
    boolean addContent(Content content);
}
