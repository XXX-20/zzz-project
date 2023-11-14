package com.zzz.blog.dao;

import lombok.Data;

@Data
public class ArticleInfo {
    private int id;

    private String createBy;

    private String createDate;

    private String updateBy;

    private String updateDate;

    private int version;

    private boolean deletedStatus;

    private String author;

    private String type;

    private boolean topStatus;

    private boolean originalStatus;

    private boolean privateStatus;
}
