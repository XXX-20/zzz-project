package com.zzz.ystools.service;



import com.zzz.ystools.dao.CharacterAttr;
import com.zzz.ystools.mapper.CharacterAttrMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CharacterAttrServiceImpl implements CharacterAttrService{
    @Resource
    CharacterAttrMapper characterAttrMapper;


    @Override
    public CharacterAttr getCharacterAttrByName(String name) {
        return characterAttrMapper.getCharacterAttrByName(name);
    }
}
