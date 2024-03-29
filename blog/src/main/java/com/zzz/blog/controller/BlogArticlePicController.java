package com.zzz.blog.controller;

import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/blog-article-pic")
public class BlogArticlePicController {

    @GetMapping("/hello")
    @ApiOperation("hello")
    public String hello() {
        return "hello";
    }

}
