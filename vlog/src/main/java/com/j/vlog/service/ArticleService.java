package com.j.vlog.service;

import com.j.vlog.model.entity.Article;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author orange
 * @Date 15.12.20
 **/

public interface ArticleService {

    /**
     * 批量新增文章
     *
     * @param articles 文章集合
     */
    void insertArticles(List<Article> articles);

    /**
     * 查询所有文章
     *
     * @return List<Article>
     */
    List<Article> selectAll();
}
