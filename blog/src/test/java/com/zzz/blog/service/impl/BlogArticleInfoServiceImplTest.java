package com.zzz.blog.service.impl;

import com.zzz.blog.BlogApplication;
import com.zzz.blog.entity.BlogArticleInfo;
import com.zzz.blog.service.BlogArticleInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BlogArticleInfoServiceImplTest {

    @Autowired
    public BlogArticleInfoService blogArticleInfoService;
    @Test
    void getById() {
        BlogArticleInfo articleInfo = blogArticleInfoService.getById(1);
        System.out.println("articleInfo = " + articleInfo);
    }
}