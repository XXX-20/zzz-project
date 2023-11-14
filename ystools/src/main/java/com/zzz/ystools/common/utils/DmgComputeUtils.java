package com.zzz.ystools.common.utils;



import com.zzz.ystools.character.CharacterInterface;
import com.zzz.ystools.common.bonus.res.AttrBonusRes;
import com.zzz.ystools.common.bonus.res.BonusListRes;
import com.zzz.ystools.common.bonus.res.BonusRes;
import com.zzz.ystools.dao.CharacterAttr;
import com.zzz.ystools.enums.BonusEnum;

import java.util.List;
import java.util.Map;

/**
 * 伤害计算类
 * 伤害=角色属性区（攻击、生命、防御等）*倍率区*增伤区*暴击区*反应区*防御区*抗性区
 * @Date: 2023/10/12 9:01
 * @Since: 1.0
 * @Auther：zzz
 */
public class DmgComputeUtils {


    /**
     * 统计角色自身乘区和
     * @param characterAttr
     * @param bonusRes
     * @return
     */
    private List<Double> statBouns(CharacterAttr characterAttr, BonusRes bonusRes) {
        return null;
    }


    /**
     * 更新角色面板
     * @param chaAttr 角色面板
     * @param bonusListRes 属性加成
     * @return 更新后的面板
     */
    public static CharacterAttr updateChaAttr(CharacterAttr chaAttr, BonusListRes bonusListRes) {


        AttrBonusRes abr = bonusListRes.getAttrBonusRes();
        Map<String, Double> bonusList = abr.getBonusList();
        // 基础攻击力 = 角色初始 + 武器
        Double atkBase = bonusList.getOrDefault(BonusEnum.ATK_BASE.getDescription(), 0.0);
        chaAttr.setAttack(chaAttr.getAttack() + atkBase);
        // 更新面板
        CharacterAttr res = new CharacterAttr(chaAttr);
        for (Map.Entry<String, Double> entry : bonusList.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            // 百分比类型的属性加成都乘以chaAttr的属性值。
            // 别忘了加上res原来的属性值
            if (key.equals(BonusEnum.HP_PERCENT.getDescription())) {
                res.setHealthPoints((value / 100) * chaAttr.getHealthPoints() + res.getHealthPoints());
            } else if (key.equals(BonusEnum.HP.getDescription())) {
                res.setHealthPoints(value + res.getHealthPoints());
            } else if (key.equals(BonusEnum.ELEMENTAL_MASTERY.getDescription())) {
                res.setElementalMastery(value + res.getElementalMastery());
            } else if (key.equals(BonusEnum.DEF.getDescription())) {
                res.setDefence(value + res.getDefence());
            } else if (key.equals(BonusEnum.DEF_PERCENT.getDescription())) {
                res.setDefence((value / 100) * chaAttr.getDefence() + res.getDefence());
            } else if (key.equals(BonusEnum.CRITICAL_RATE.getDescription())) {
                res.setCriticalRate(value + res.getCriticalRate());
            } else if (key.equals(BonusEnum.CRITICAL_DMG.getDescription())) {
                res.setCriticalDamage(value + res.getCriticalDamage());
            } else if (key.equals(BonusEnum.ENERGY_RECHARGE.getDescription())) {
                res.setEnergyRecharge(value + res.getEnergyRecharge());
            } else if (key.equals(BonusEnum.ATK.getDescription())) {
                res.setAttack(value + res.getAttack());
            } else if (key.equals(BonusEnum.ATK_PERCENT.getDescription())) {
                res.setAttack((value / 100) * chaAttr.getAttack() + res.getAttack());
            }
        }
        // 将突破属性更新到面板


        return res;
    }

    private void updateBreakAttrToPanel(CharacterAttr chaAttr) {
        String breakAttr = chaAttr.getBreakAttr();
        String[] split = breakAttr.split(":");
        String attrName = split[0];
        double attrValue = Double.parseDouble(split[1].substring(0, split[1].length() - 1));
        if (attrName.equals(BonusEnum.CRITICAL_DMG.getDescription())) {
            chaAttr.setCriticalDamage(attrValue - 50 + chaAttr.getCriticalDamage());
        }

    }

    /**
     * 攻击区伤害计算
     * @Since: 1.0
     * @Auther：zzz
     */
    public double atkDmgCmp(CharacterInterface characterInterface, BonusRes bonusRes) {
        return 0.0;
    }

    /**
     * 生命区伤害计算【角色属性区（生命）*倍率区*增伤区*暴击区*反应区*防御区*抗性区】
     * @Since: 1.0
     * @Auther：zzz
     */
    public double hpDmgCmp(double factor, CharacterAttr characterAttr, BonusRes bonusRes) {

        return 0.0;
    }


}
