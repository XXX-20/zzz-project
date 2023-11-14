package com.zzz.ystools.service;


import com.zzz.ystools.YstoolsApplication;
import com.zzz.ystools.dao.CharacterAttr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = YstoolsApplication.class)
class CharacterAttrServiceImplTest {

    @Autowired
    CharacterAttrServiceImpl characterAttrServiceImpl;

    @Test
    public void getCharacterAttrByName() {
        CharacterAttr yelan = characterAttrServiceImpl.getCharacterAttrByName("夜兰");
        System.out.println("yelan = " + yelan);
    }
}