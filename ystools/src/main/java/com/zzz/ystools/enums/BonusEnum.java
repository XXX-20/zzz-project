package com.zzz.ystools.enums;

/**
 * 乘区枚举类
 * @Date: 2023/10/10 10:59
 * @Since: 1.0
 * @Auther：zzz
 *
 */
public enum BonusEnum {
    /**
     * 	伤害=攻击区*倍率区*增伤区*暴击区*反应区*防御区*抗性区
     *
     * 	Damage=A区 * M区 * B区 * C区 * E区 * D区 * R区
     *
     * 	攻击区= A = Attack
     *
     * 	倍率区= M = Damage Multipiler
     *
     * 	增伤区= B = Damage Bonus
     *
     * 	暴击区= C = Critical Bracket
     *
     * 	反应区= E = Elemental Reaction
     *
     * 	防御区= D = Defense
     *
     * 	抗性区= R = Resistance
     */
    HP("生命值"),
    HP_PERCENT("生命值百分比"),

    ATK_BASE("基础攻击力"),
    ATK("攻击力"),
    ATK_PERCENT("攻击力百分比"),

    DEF("防御力"),
    DEF_PERCENT("防御力百分比"),

    ELEMENTAL_MASTERY("元素精通"),

    CRITICAL_RATE("暴击率"),
    CRITICAL_DMG("暴击伤害"),

    ENERGY_RECHARGE("元素充能效率"),


    LV_MONSTER("怪物等级"),

    DEF_MONSTER("怪物防御力"),

    PYRO_RES_MONSTER("怪物火属性抗性"),
    HYDRO_RES_MONSTER("怪物水属性抗性"),
    DENDRO_RES_MONSTER("怪物草属性抗性"),
    ELECTRO_RES_MONSTER("怪物雷属性抗性"),
    ANEMO_RES_MONSTER("怪物风属性抗性"),
    CRYO_RES_MONSTER("怪物冰属性抗性"),
    GEO_RES_MONSTER("怪物岩属性抗性"),
    PHYSICAL_RES_MONSTER("怪物物理属性抗性"),


    B("增伤区"),

    B_BURST("元素爆发增伤区");

    private final String description;

    public String getDescription() {
        return description;
    }

    BonusEnum(String description) {
        this.description = description;
    }

}
