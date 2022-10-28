package online.niuma.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import online.niuma.blog.dto.ArticleDto;
import online.niuma.blog.dto.ContentDto;
import online.niuma.blog.mapper.ArticlesMapper;
import online.niuma.blog.pojo.Articles;
import online.niuma.blog.pojo.Content;
import online.niuma.blog.service.ArticleService;
import online.niuma.blog.service.ContentService;
import online.niuma.blog.vo.ArticleVo;
import online.niuma.blog.vo.ContentVo;
import online.niuma.blog.vo.params.ArticleParam;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    /**
     * 添加文章
     * @param articleParam 文章信息
     */
    @Override
    public boolean addArticle(ArticleParam articleParam) {
        log.info("execute addArticle() function");
        int contentLength = 140;
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

    /**
     * 查询所有的文章信息
     */
    @Override
    public List<ArticleVo> getArticleInfoAll() {
        List<ArticleDto> articleDto = this.articlesMapper.queryArticleAll();
        return copyList(articleDto);
    }

    /**
     * 根据文章的 id 查询文章的信息
     * @param articleId 文章 id
     */
    @Override
    public ContentVo queryArticleOneById(String articleId) {
        ContentVo contentVo = new ContentVo();
        ContentDto articleInfo = this.articlesMapper.queryArticleOne(articleId);
        BeanUtils.copyProperties(articleInfo, contentVo);
        contentVo.setCreateTime(new DateTime(articleInfo.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
        return contentVo;
    }

    private ArticleVo copy(ArticleDto articleDto) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(articleDto, articleVo);
        articleVo.setCreateTime(new DateTime(articleDto.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
        return articleVo;
    }

    private List<ArticleVo> copyList(List<ArticleDto> articleDtoList) {
        ArrayList<ArticleVo> articleVoList = new ArrayList<>();
        for (ArticleDto articleDto : articleDtoList) {
            articleVoList.add(copy(articleDto));
        }
        return articleVoList;
    }

}
