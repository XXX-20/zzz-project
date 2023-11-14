package com.zzz.ystools.character;



import com.zzz.ystools.common.DmgComputeArg;
import com.zzz.ystools.common.bonus.res.AttrBonusRes;
import com.zzz.ystools.common.bonus.res.BonusListRes;
import com.zzz.ystools.common.bonus.res.DmgBonusRes;
import com.zzz.ystools.common.utils.DmgComputeUtils;
import com.zzz.ystools.dao.CharacterAttr;
import com.zzz.ystools.dao.talents.battle.ElementalBurst;
import com.zzz.ystools.dao.talents.battle.ElementalSkill;
import com.zzz.ystools.dao.talents.battle.InherentGift;
import com.zzz.ystools.dao.talents.battle.OriginalAttack;
import com.zzz.ystools.enums.BonusEnum;
import com.zzz.ystools.service.CharacterAttrService;
import com.zzz.ystools.weapon.Bow;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 技能默认十级
 */
@Component
@Data
public class Yelan implements CharacterInterface {

    @Resource
    CharacterAttrService characterAttrService;

    private static Yelan yelan;

    @PostConstruct
    public void init() {
        // 缓存service
        yelan = this;
        yelan.characterAttrService = this.characterAttrService;
    }

    public CharacterAttr initCharacterAttr() {
        characterAttr = yelan.characterAttrService.getCharacterAttrByName("夜兰");
        // 将突破属性添加到面板
        // String breakAttr = characterAttr.getBreakAttr();
        // if (!breakAttr.contains("元素伤害加成")) {
        //
        // }
        return characterAttr;
    }

    private CharacterAttr characterAttr;

    @Data
    @ToString
    static class Attack extends OriginalAttack {

        // 满蓄力瞄准射击
        private Double aimingDamageWithFullForce;
        // 破局矢伤害(生命值)
        private Double breakingArrowDamageByHp;

        public Attack() {
            this.setFirstStageInjury(80.4);
            this.setSecondStageInjury(77.2);
            this.setThirdStageInjury(102.0);
            this.setForthStageInjury(64.3 + 64.3);
            this.setAimingDamage(86.7);
            this.aimingDamageWithFullForce = 86.7;
            this.breakingArrowDamageByHp = 20.84;
            this.setLowFallingInjury(225.0);
            this.setHighFallingInjury(281.0);
            this.setDuringFallingInjury(112.3);
        }

        @Override
        public String toString() {
            return "Attack{" +
                    "aimingDamageWithFullForce=" + aimingDamageWithFullForce +
                    ", breakingArrowDamageByHp=" + breakingArrowDamageByHp +
                    "} " + super.toString();
        }
    }

    @Data
    static class CombatSkill extends ElementalSkill {
        // 技能伤害
        private Double skillDamageByHp = 40.7;
        // 长按最大持续时间
        private Double maxDurationOfLongPress = 3.0;

        public CombatSkill() {
            this.setCoolingTime(10.0);
        }

        @Override
        public String toString() {
            return "Skill{" +
                    "skillDamageByHp=" + skillDamageByHp +
                    ", maxDurationOfLongPress=" + maxDurationOfLongPress +
                    "} " + super.toString();
        }
    }

    @Data
    static class Burst extends ElementalBurst {
        // 技能伤害(生命值)
        private Double skillDamageByHp = 13.15;
        // 玄掷玲珑伤害(生命值)
        private Double ExquisiteDiceDamageByHp = 8.77 * 3;

        public Burst() {
            this.setDurationTime(15.0);
            this.setCoolingTime(18.0);
            this.setElementalEnergy(70.0);
        }

        @Override
        public String toString() {
            return "Brust{" +
                    "skillDamageByHp=" + skillDamageByHp +
                    ", ExquisiteDiceDamageByHp=" + ExquisiteDiceDamageByHp +
                    "} " + super.toString();
        }
    }

    /**
     * 天赋内部类
     *
     * @Date: 2023/10/17 17:10
     * @Since: 1.0
     * @Auther：zzz
     */
    @Data
    static class Gift implements InherentGift {

        // 队伍存在1/2/3/4种元素类型的角色时，夜兰的生命值上限提升6%/12%/18%/30%
        @Override
        public BonusListRes one(DmgComputeArg dmgComputeArg) {
            if (!dmgComputeArg.getCurrCharName().equals(new Yelan().initCharacterAttr().getName())) {
                return new BonusListRes.Builder().source("夜兰天赋1").build();
            }
            double data = 6;
            int teamNum = dmgComputeArg.getTeamNum();
            if (teamNum < 4) {
                data = data * teamNum;
            } else {
                data = 30;
            }
            double finalData = data;
            return new BonusListRes.Builder()
                    .attrBonusRes(AttrBonusRes.getInstance(BonusEnum.HP_PERCENT.getDescription(), finalData))
                    .source("夜兰天赋1-"+ "队伍存在"+ teamNum + "种元素类型").build();
        }

        /**
         * [玄掷玲珑」存在期间，能使队伍中自己的当前场上角色造成的伤害提高1%，并且每1秒进一步提高3.5%，至多使角色造成的伤害提高50%。
         * 效果存在期间重新施放渊图玲珑骰，将移除原有的上述效果。
         * 大招持续15s，第14s加成达到50%。
         *
         * 考虑单人持续站场，不切人，返回站场时间的平均伤害加成。
         */
        @Override
        public BonusListRes two(DmgComputeArg dmgComputeArg) {
            int maxTime = new Burst().getDurationTime().intValue();
            double maxUp = 50.0;
            double currentUp = 1.0;
            double stageUp = 3.5;
            double totalUp = 0.0;
            double residentTime = dmgComputeArg.getResidentTime();
            for (int i = 1; i <= (Math.min(residentTime, maxTime)); i++) {
                currentUp = currentUp < maxUp ? currentUp + stageUp : maxUp;
                // System.out.println(i + "s: " + currentUp);
                totalUp += currentUp;
            }
            double averageUp = totalUp / Math.min(residentTime, maxTime);
            // 保留两位小数
            double result = Double.parseDouble(String.format("%.1f", averageUp));
            return new BonusListRes.Builder()
                    .dmgBonusRes(DmgBonusRes.getInstance(BonusEnum.B.getDescription(), result))
                    .source("夜兰天赋2-持续站场"+ residentTime + "s").build();
        }
    }


    /**
     * 【单人无其他buff】元素战技伤害伤害计算。
     *      1.在战斗过程中，面板是实时变动的，乘区加成也是事实变动的。如何动态的计算伤害？
     *      2.这里只考虑单人情况，面板较为固定。但是要实现一个智能的计算顺序：先计算属性加成，后计算伤害加成
     *      3.每个影响因素都可能包含两种加成。
     *          先获取所有影响因素的的属性加成，更新角色的属性面板。
     *          后根据属性面板获取伤害加成。
     * 1.乘区的增加是有先后顺序的，伤害乘区的加成取决于角色属性，但角色属性会受属性乘区变动。
     * 2.要先确定面板，然后计算乘区加成。即先筛选出所有的属性乘区，计算属性面板后，再计算伤害。
     * 3.一个角色可以圣遗物可以带2+2，或者四件套，或者全散件（无套装效果）。
     * 4.圣遗物不仅要考虑套装效果，还要考虑等级（主副词条情况）
     *
     * @Since: 1.0
     * @Auther：zzz
     */
    public List<Double> combatSkillDmgBySingle(DmgComputeArg dmgCptArg) {
        // 初始面板
        CharacterAttr attr = new Yelan().initCharacterAttr();

        // 武器
        BonusListRes invoke = Bow.invoke(dmgCptArg.getBowName(), 1);
        // 天赋
        BonusListRes one = dmgCptArg.getGift().one(dmgCptArg);
        BonusListRes two = dmgCptArg.getGift().two(dmgCptArg);
        //圣遗物词条属性
        BonusListRes artifactEntries = dmgCptArg.getArtifactEntries();

        // 圣遗物套装

        BonusListRes artifactSuit = dmgCptArg.getArtifactSuit(attr);

        BonusListRes attrBonus = BonusListRes.mergeAll(invoke, one, two, artifactEntries, artifactSuit);
        System.out.println("attrBonus = " + attrBonus);

        // 更新面板
        System.out.println("初始属性面板=" + attr.getDataPanel());
        CharacterAttr updatedChaAttr = DmgComputeUtils.updateChaAttr(attr, attrBonus);
        System.out.println("属性加成后面板=" + updatedChaAttr.getDataPanel());

        // 原魔属性
        BonusListRes monster = dmgCptArg.getMonster().reduceBonus();

        return null;
    }


}
