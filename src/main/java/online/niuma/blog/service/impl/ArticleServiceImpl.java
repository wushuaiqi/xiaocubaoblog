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
     * todo 将前端获取到的文章信息进行转换
     * 将传来的文章信息封装到 Articles 实体类和 Content 实体类中
     * todo 将文章的内容截取固定的长度放入文章摘要中
     * @param articleParam 将要插入的文章信息
     */
    @Override
    public boolean addArticle(ArticleParam articleParam) {
        log.info("execute addArticle() function");
        // 定义将要截取文章内容的长度
        int contentLength = 140;
        // 分别生成文章的 id 和 内容的 id
        String articleId = UUID.randomUUID().toString();
        String contentId = UUID.randomUUID().toString();
        Articles article = new Articles();
        Content content = new Content();
        article.setArticleId(articleId);
        article.setArticleTitle(articleParam.getArticleTitle());
        // 存储文章内容的摘要，如果文章的长度小于指定的内容则直接将其内容存入摘要内容中
        if (articleParam.getContent().length() < contentLength) {
            article.setArticleSketch(articleParam.getContent());
        } else {  // 否者则截取指定的长度
            article.setArticleSketch(articleParam.getContent().substring(0, contentLength));
        }
        // 将获取到的 content 内容进行格式装换
        // 因为传输过来的内容存入数据库的时候不会记录换行，所以将文章的内容格式化一下再存入
        // 按照换行符进行切割
        String[] strList = articleParam.getContent().split("\n");
        // 将切割后的数组中的第一个元素作为初始值
        String tmp = strList[0];
        // 使用循环将这些截取到的元素连接起来，在换行的地方添加 html 的换行标签 <br/>
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
        // 存入文章的内容信息
        boolean contentFlag = this.contentService.addContent(content);
        // 初始化一个 flag
        boolean articleFlag = false;
        // 存入文章的信息
        int i = this.articlesMapper.addArticle(article);
        // 如果输出插入成功就将 flag 改为 true
        if (i > 0) {
            articleFlag = true;
        }
        // 如果两条内容都插入成功返回 true 否则返回 false
        return contentFlag && articleFlag;
    }

    /**
     * 查询所有的文章信息
     * todo 调用 ArticleMapper 中的 queryArticleAll() 方法查询出所有的文章信息
     * 调用 copyList() 方法对对象的类型进行转换
     * @return 经过处理后的 ArticleVo 类型的集合
     */
    @Override
    public List<ArticleVo> getArticleInfoAll() {
        List<ArticleDto> articleDto = this.articlesMapper.queryArticleAll();
        return copyList(articleDto);
    }

    /**
     * 根据文章的 id 查询文章的信息
     * todo 将 ArticleDto 对象转换成 ArticleVo 对象
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

    /**
     * todo 将 ArticleDto 对象中的属性转换成 ArticleVo对象中的属性
     * @param articleDto SQL 查询后的内容对象映射
     * @return 转换成 ArticleVo 后的对象
     */
    private ArticleVo copy(ArticleDto articleDto) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(articleDto, articleVo);
        // 因为在 ArticleVo 中的 createTime 属性是 String 类型的，所以我们需要对此进行格式化转换
        articleVo.setCreateTime(new DateTime(articleDto.getCreateTime()).toString("yyyy-MM-dd HH:mm"));
        return articleVo;
    }

    /**
     * 将 ArticleDto 的集合转换成 ArticleVo 的集合
     * @param articleDtoList ArticleDto 类型集合
     * @return ArticleVo 类型集合
     */
    private List<ArticleVo> copyList(List<ArticleDto> articleDtoList) {
        ArrayList<ArticleVo> articleVoList = new ArrayList<>();
        for (ArticleDto articleDto : articleDtoList) {
            articleVoList.add(copy(articleDto));
        }
        return articleVoList;
    }

}
