package com.zzz.ystools.mapper;


import com.zzz.ystools.YstoolsApplication;
import com.zzz.ystools.dao.CharacterAttr;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(classes = YstoolsApplication.class)
class CharacterMapperTest {

    @Autowired
    CharacterAttrMapper characterAttrMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testSelect() {
        List<CharacterAttr> characterAttrs = characterAttrMapper.selectList(null);
        Assert.isTrue(characterAttrs.size() > 0, "yes");
        characterAttrs.forEach(System.out::println);
    }

    @AfterEach
    void tearDown() {
    }
}