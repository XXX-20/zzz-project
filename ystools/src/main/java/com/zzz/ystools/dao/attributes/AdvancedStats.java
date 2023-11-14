package com.zzz.ystools.dao.attributes;

/**
 * @author zzz
 * @description 角色进阶属性
 * @date 2023-08-22 23:26
 */
@Deprecated
public class AdvancedStats {
    /**
     * 暴击率CRIT
     */
    private final Double criticalRate = 5.0;

    /**
     * 暴击伤害CRIT DMG
     */
    private final Double criticalDamage = 50.0;

    /**
     * 治疗加成
     */
    private Double healingBonus;

    /**
     * 受治疗加成
     */
    private Double incomingHealingBonus;

    /**
     * 元素充能效率
     */
    private Double energyRecharge;

    /**
     * 冷却缩减
     */
    private Double cdReduction;

    /**
     * 护盾强效
     */
    private Double shieldStrength;
}
