package com.zzz.ystools.artifact;

/**
 * 简体中文:生之花 英语:Flower of Life
 * <p>
 * 简体中文:死之羽 英语:Plume of Death
 * <p>
 * 简体中文:时之沙 英语:Sands of Eon
 * <p>
 * 简体中文:空之杯 英语:Goblet of Eonothem
 * <p>
 * 简体中文:理之冠 英语:Circlet of Logos
 * https://zhidao.baidu.com/question/2084941633921344108.html
 */

import com.zzz.ystools.common.bonus.res.AttrBonusRes;
import com.zzz.ystools.common.bonus.res.BonusListRes;
import com.zzz.ystools.common.bonus.res.DmgBonusRes;
import com.zzz.ystools.common.dict.ArtifactDict;
import com.zzz.ystools.dao.CharacterAttr;
import com.zzz.ystools.enums.BonusEnum;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 圣遗物类。
 * 1.提供一个外部接口，根据圣遗物名称映射对应的方法名，通过反射调用，返回对应的套装效果。
 * @Date: 2023/10/7 16:57
 * @Since: 1.0
 * @Auther：zzz
 */
public class Artifact {

    public static BonusListRes invoke(String artifactName, int suitNum, CharacterAttr characterAttr) {
        Class<?> artifact = Artifact.class;
        artifactName = ArtifactDict.cToE(artifactName);
        Method method = null;
        try {
            method = artifact.getDeclaredMethod(artifactName, int.class, CharacterAttr.class);
            return (BonusListRes) method.invoke(new Artifact(), suitNum, characterAttr);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("该圣遗物暂未录入或名称错误");
        }
    }

    /**
     * 绝缘之旗印：
     * 两件套效果：元素充能效率提高20%。
     * 四件套效果：基于元素充能效率的25%，提高元素爆发造成的伤害。至多通过这种方式获得75%提升。
     * 注意：四件套效果包含二件套效果。
     * 问题一：大招期间，绝缘四给的加成会根据角色元素充能效率变化而变化吗？
     *          会。
     * @param characterAttr 角色面板
     * @param suitNum 套装数量
     * @return
     */
    public BonusListRes emblemOfSeveredFate(int suitNum, CharacterAttr characterAttr) {
        if (suitNum < 2 || suitNum > 4) {
            return new BonusListRes.Builder().build();
        }
        AttrBonusRes twoPieceEffect = AttrBonusRes.getInstance(BonusEnum.ENERGY_RECHARGE.getDescription(), 20.0);
        if (suitNum < 4) {
            return new BonusListRes.Builder().attrBonusRes(twoPieceEffect)
                    .source("绝缘2")
                    .build();
        }
        // 加上两件套效果的20%元素充能效率计算四件套元素爆发增伤效果
        Double up = (characterAttr.getEnergyRecharge() + 20) * 0.25;
        return new BonusListRes.Builder()
                .dmgBonusRes(DmgBonusRes.getInstance(BonusEnum.B_BURST.getDescription(), up))
                .source("绝缘4")
                .build();
    }
}
