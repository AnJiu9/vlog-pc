package com.j.vlog.service.impl;

import com.j.vlog.mapper.ArticleMapper;
import com.j.vlog.mapper.ArticleTagMapper;
import com.j.vlog.model.entity.Article;
import com.j.vlog.model.entity.ArticleTag;
import com.j.vlog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ArticleSerciveImpl
 * @Description
 * @Author orange
 * @Date 2020-12-15 15:55
 **/

@Component
@Slf4j
public class ArticleSerciveImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Override
    public void insertArticles(List<Article> articles) {
        articleMapper.insertArticles(articles);
        assert articles != null;
        articles.forEach(article -> {
            if (article.getTagList() != null) {
                articleTagMapper.insertArticleTags(article.getTagList());
            }
        });
    }

    @Override
    public List<Article> selectAll() {
        List<Article> articles = articleMapper.selectAll();
        articles.forEach(article -> {
            List<ArticleTag> articleTags = articleTagMapper.selectByArticleId(article.getId());
            article.setTagList(articleTags);
        });
        return articles;
    }
}
