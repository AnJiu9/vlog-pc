package com.j.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName Article
 * @Description 文章实体
 * @Author orange
 * @Date 2020-12-15 14:00
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private String id;
    private String category;
    private Integer userId;
    private String title;
    private String cover;
    private String summary;
    private String content;
    private String url;
    private LocalDate publishDate;
    private String totalWords;
    private Integer duration;
    private Integer pageView;
    private List<ArticleTag> tagList;

}
