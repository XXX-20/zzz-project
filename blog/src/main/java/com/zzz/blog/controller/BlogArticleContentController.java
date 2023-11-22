package com.zzz.blog.controller;

import com.zzz.blog.entity.BlogArticleContent;
import com.zzz.blog.entity.BlogArticleInfo;
import com.zzz.blog.service.BlogArticleContentService;
import com.zzz.blog.service.BlogArticleInfoService;
import com.zzz.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-11-22
 */
@Api(tags = "blog - blog-article-content")
@RestController
@RequestMapping("/blog-article-content")
public class BlogArticleContentController {

    @Autowired
    public BlogArticleContentService blogArticleContentService;

    @GetMapping("/get")
    @ApiOperation("test")
    public CommonResult<BlogArticleContent> get() {
        BlogArticleContent content = blogArticleContentService.getById(1);
        return CommonResult.success(200, content, "");
    }

    // @PostMapping("/save")
    // public CommonResult<String> save(@RequestBody String updateContent){
    //
    // }
}