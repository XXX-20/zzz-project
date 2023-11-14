package com.zzz.ystools.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zzz.ystools.dao.CharacterAttr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CharacterAttrMapper extends BaseMapper<CharacterAttr> {

    default CharacterAttr getCharacterAttrByName(String name) {
        return selectOne(new LambdaQueryWrapper<CharacterAttr>().eq(CharacterAttr::getName, name));
    }
}
