package com.zzz.ystools.monster;


import com.zzz.ystools.common.bonus.res.BonusListRes;
import com.zzz.ystools.common.bonus.res.DmgBonusRes;
import com.zzz.ystools.enums.BonusEnum;
import lombok.Data;

/**
 * 原魔公共父类
 * @Date: 2023/10/11 16:40
 * @Since: 1.0
 * @Auther：zzz
 */
@Data
public class Monster {

    private Long id;

    /**
     * 等级
     */
    private int level;

    /**
     * 名称
     */
    private String name;

    /**
     * 称号
     */
    private String specialDish;

    /**
     * 层级
     */
    private String rank;

    /**
     * 生命值上限hp
     */
    private Double healthPoints;

    /**
     * 攻击力atk
     */
    private Double attack;

    /**
     * 防御力def
     */
    private Double defence = 0.0;

    /**
     * 火元素伤害加成
     */
    private Double pyroDmgBonus;

    /**
     * 火元素抗性
     */
    private Double pyroRes = 0.0;

    /**
     * 水元素伤害加成
     */
    private Double hydroDmgBonus;

    /**
     * 水元素抗性
     */
    private Double hydroRes = 0.0;

    /**
     * 草元素伤害加成
     */
    private Double dendroDmgBonus;

    /**
     * 草元素抗性
     */
    private Double dendroRes = 0.0;

    /**
     * 雷元素伤害加成
     */
    private Double electroDmgBonus;

    /**
     * 雷元素抗性
     */
    private Double electroRes = 0.0;

    /**
     * 风元素伤害加成
     */
    private Double anemoDmgBonus;

    /**
     * 风元素抗性
     */
    private Double anemoRes = 0.0;

    /**
     * 冰元素伤害加成
     */
    private Double cryoDmgBonus;

    /**
     * 冰元素抗性
     */
    private Double cryoRes = 0.0;

    /**
     * 岩元素伤害加成
     */
    private Double geoDmgBonus;

    /**
     * 岩元素抗性
     */
    private Double geoRes = 0.0;


    /**
     * 物理伤害加成
     */
    private Double physicalDmgBonus;

    /**
     * 物理抗性
     */
    private Double physicalRes = 0.0;

    /**
     * 包括防御乘区、八种抗性乘区、等级压制
     * 把怪物的防御值视为单位1，减防都是按照百分比减防。所以把防御乘区划分为伤害乘区。
     * @Since: 1.0
     * @Auther：zzz
     */ 
    public BonusListRes reduceBonus() {
        DmgBonusRes dmgBonusRes = DmgBonusRes.getInstance(BonusEnum.DEF_MONSTER.getDescription(), defence)
                .add(BonusEnum.PYRO_RES_MONSTER.getDescription(), pyroRes)
                .add(BonusEnum.HYDRO_RES_MONSTER.getDescription(), hydroRes)
                .add(BonusEnum.ELECTRO_RES_MONSTER.getDescription(), electroRes)
                .add(BonusEnum.PHYSICAL_RES_MONSTER.getDescription(), physicalRes)
                .add(BonusEnum.GEO_RES_MONSTER.getDescription(), geoRes)
                .add(BonusEnum.CRYO_RES_MONSTER.getDescription(), cryoRes)
                .add(BonusEnum.ANEMO_RES_MONSTER.getDescription(), anemoRes)
                .add(BonusEnum.DENDRO_RES_MONSTER.getDescription(), dendroRes)
                .add(BonusEnum.LV_MONSTER.getDescription(), (double) level);
        return new BonusListRes.Builder().dmgBonusRes(dmgBonusRes).source("原魔").build();
    }
}
