package com.zzz.ystools.weapon;


import com.zzz.ystools.YstoolsApplication;
import com.zzz.ystools.common.bonus.res.BonusListRes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = YstoolsApplication.class)
class BowTest {

    @Test
    public void invoke() {
        Bow bow = new Bow();
        try {
            BonusListRes ruoshui = bow.invoke("若水", 1);
            System.out.println("若水 = " + ruoshui);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}