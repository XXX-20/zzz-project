package com.zzz.blog.controller;

import com.zzz.blog.entity.BlogArticleInfo;
import com.zzz.blog.service.BlogArticleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "blog - blog-article-info")
@RestController
@RequestMapping("/blog-article-info")
public class BlogArticleInfoController {

    @Autowired
    public BlogArticleInfoService blogArticleInfoService;

    @GetMapping("/get")
    @ApiOperation("test")
    public BlogArticleInfo get() {
        return blogArticleInfoService.getById(1);
    }

    @GetMapping("/hello")
    @ApiOperation("hello")
    public String hello() {
        return "hello";
    }
}
