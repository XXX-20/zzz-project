package com.zzz.ystools.dao;


import com.zzz.ystools.YstoolsApplication;
import com.zzz.ystools.character.Yelan;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest(classes = YstoolsApplication.class)
class CharacterAttrTest {

    @Test
    void handleBreakAttr() {
        CharacterAttr characterAttr = new Yelan().initCharacterAttr();
        String breakAttr = characterAttr.getBreakAttr();
        HashMap<String, Double> stringDoubleHashMap = characterAttr.handleBreakAttr();
        System.out.println("stringDoubleHashMap = " + stringDoubleHashMap);
    }

    @Test
    void getDataPanel() {
    }
}