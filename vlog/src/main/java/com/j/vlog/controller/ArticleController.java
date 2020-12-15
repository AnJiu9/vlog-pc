package com.j.vlog.controller;

import com.j.vlog.common.ResponseResult;
import com.j.vlog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ArticleController
 * @Description
 * @Author orange
 * @Date 2020-12-15 16:20
 **/

@RestController
@RequestMapping(value = "/api/article")
@Slf4j
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping("all")
    public ResponseResult getArticles(){
        return ResponseResult.success(articleService.selectAll());
    }
}
