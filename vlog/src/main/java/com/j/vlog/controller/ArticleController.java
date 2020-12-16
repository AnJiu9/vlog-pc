package com.j.vlog.controller;

import com.j.vlog.common.ResponseResult;
import com.j.vlog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("page")
    public ResponseResult getArticlesByPage(@RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                            @RequestParam(name = "pageSize", defaultValue = "9", required = false) int pageSize) {
        //通过RequestContextHolder来取得请求的request对象
        RequestAttributes at = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) at;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //取得请求头
        System.out.println(request.getHeader("userId"));
        int userId = Integer.parseInt(request.getHeader("userId"));
        return ResponseResult.success(articleService.selectByPage(pageNum, pageSize, userId));
    }
}
