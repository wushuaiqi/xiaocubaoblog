package online.niuma.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.mapper.ArticlesMapper;
import online.niuma.blog.pojo.Articles;
import online.niuma.blog.pojo.Content;
import online.niuma.blog.service.ArticleService;
import online.niuma.blog.service.ContentService;
import online.niuma.blog.vo.ArticleVo;
import online.niuma.blog.vo.params.ArticleParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticlesMapper articlesMapper;
    private ContentService contentService;

    @Autowired
    public void setArticlesMapper(ArticlesMapper articlesMapper) {
        this.articlesMapper = articlesMapper;
    }

    @Autowired
    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    @Override
    public boolean addArticle(ArticleParam articleParam) {
        log.info("execute addArticle() function");
        int contentLength = 150;
        String articleId = UUID.randomUUID().toString();
        String contentId = UUID.randomUUID().toString();
        Articles article = new Articles();
        Content content = new Content();
        article.setArticleId(articleId);
        article.setArticleTitle(articleParam.getArticleTitle());
        if (articleParam.getContent().length() < contentLength) {
            article.setArticleSketch(articleParam.getContent());
        } else {
            article.setArticleSketch(articleParam.getContent().substring(0, contentLength));
        }
        // 将获取到的 content 内容进行格式装换
        String[] strList = articleParam.getContent().split("\n");
        String tmp = strList[0];
        for (int i = 1; i < strList.length; i++) {
            tmp = String.join("<br/>", tmp, strList[i]);
        }
        articleParam.setContent(tmp);
        article.setUserId(articleParam.getUserId());
        article.setContentId(contentId);
        article.setDeleted(0);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        content.setContentId(contentId);
        content.setArticleId(articleId);
        content.setContentText(tmp);
        content.setCreateTime(new Date());
        content.setUpdateTime(new Date());
        boolean contentFlag = this.contentService.addContent(content);
        boolean articleFlag = false;
        int i = this.articlesMapper.addArticle(article);
        if (i > 0) {
            articleFlag = true;
        }
        return contentFlag && articleFlag;
    }
}
