package com.zzz.blog.controller;

import com.zzz.blog.entity.BlogArticleInfo;
import com.zzz.blog.service.BlogArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-11-16
 */
@RestController
@RequestMapping("/blog-article-info")
public class BlogArticleInfoController {

    @Autowired
    public BlogArticleInfoService blogArticleInfoService;

    @GetMapping("/get")
    public BlogArticleInfo get() {
        return blogArticleInfoService.getById(1);
    }
}
