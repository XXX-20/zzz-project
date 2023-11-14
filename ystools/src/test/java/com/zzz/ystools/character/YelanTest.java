package com.zzz.ystools.character;


import com.zzz.ystools.YstoolsApplication;
import com.zzz.ystools.common.DmgComputeArg;
import com.zzz.ystools.common.bonus.res.BonusListRes;
import com.zzz.ystools.enums.BonusEnum;
import com.zzz.ystools.monster.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = YstoolsApplication.class)
class YelanTest {

    @Test
    public void attack() {
        Yelan.Attack attack = new Yelan.Attack();
        System.out.println("attack = " + attack);
        Double firstStageInjury = attack.getFirstStageInjury();
        System.out.println("firstStageInjury = " + firstStageInjury);
    }

    @Test
    public void skill() {
        Yelan.CombatSkill skill = new Yelan.CombatSkill();
        System.out.println("skill = " + skill);
    }

    @Test
    public void brust() {
        Yelan.Burst burst = new Yelan.Burst();
        System.out.println("burst = " + burst);
    }

    @Test
    public void giftTwo() {
        Yelan.Gift gift = new Yelan.Gift();
        BonusListRes two = gift.two(DmgComputeArg.builder().gift(new Yelan.Gift()).residentTime(16).build());// 3s-8%
        System.out.println("two = " + two);
    }

    @Test
    public void combatSkillDamage() {
        Yelan yelan = new Yelan();
        /**
         * 31878\67.4\255.5
         */
        Map<String, Double> artifactEntries = new HashMap<>();
        artifactEntries.put(BonusEnum.HP.getDescription(), 6272.4);
        artifactEntries.put(BonusEnum.HP_PERCENT.getDescription(), 61.1);
        artifactEntries.put(BonusEnum.ATK.getDescription(), 356.6);
        artifactEntries.put(BonusEnum.DEF.getDescription(), 79.3);
        artifactEntries.put(BonusEnum.ELEMENTAL_MASTERY.getDescription(), 42.0);
        artifactEntries.put(BonusEnum.CRITICAL_RATE.getDescription(), 43.2);
        artifactEntries.put(BonusEnum.CRITICAL_DMG.getDescription(), 117.4);
        artifactEntries.put(BonusEnum.ENERGY_RECHARGE.getDescription(), 40.7);
        artifactEntries.put(BonusEnum.B.getDescription(), 46.6);

        Map<String, Integer> artifactSuit = new HashMap<>();
        artifactSuit.put("绝缘", 4);

        yelan.combatSkillDmgBySingle(DmgComputeArg.builder()
                .bowName("若水")
                .gift(new Yelan.Gift())
                        .artifactEntries(artifactEntries)
                        .artifactSuit(artifactSuit)
                        .monster(new Monster())
                        .teamNum(1)
                        .residentTime(15)
                        .currCharName("夜兰")
                .build());
    }
}