package com.zzz.blog.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzz.blog.dao.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {
    default ArticleInfo getArticleInfoById(String name) {
        return selectOne(new LambdaQueryWrapper<ArticleInfo>().eq(ArticleInfo::getId, name));
    }
}
