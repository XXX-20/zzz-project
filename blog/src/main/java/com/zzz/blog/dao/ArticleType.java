package com.zzz.blog.dao;

import lombok.Data;

@Data
public class ArticleType {
    private int id;

    private String createBy;

    private String createDate;

    private String updateBy;

    private String updateDate;

    private int version;

    private boolean deletedStatus;

    private String typeName;

}
