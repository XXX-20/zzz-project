package com.zzz.blog.dao;

import lombok.Data;

@Data
public class ArticleContent {
    private int id;

    private String createBy;

    private String createDate;

    private String updateBy;

    private String updateDate;

    private int version;

    private boolean deletedStatus;


    private String content;

    private int articleInfoId;
}
