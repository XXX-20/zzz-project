package com.zzz.ystools.artifact;


import com.zzz.ystools.YstoolsApplication;
import com.zzz.ystools.character.Yelan;
import com.zzz.ystools.common.bonus.res.BonusListRes;
import com.zzz.ystools.dao.CharacterAttr;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = YstoolsApplication.class)
class ArtifactTest {

    @Test
    public void invoke() {
        CharacterAttr characterAttr = new Yelan().initCharacterAttr();
        System.out.println("characterAttr = " + characterAttr);
        BonusListRes invoke = Artifact.invoke("绝缘", 4, characterAttr);
        System.out.println(invoke);
    }
}