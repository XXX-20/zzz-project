package com.zzz.ystools.dao.talents.battle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzz
 * @description 元素爆发
 * @date 2023-08-23 21:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementalBurst {
    /**
     * 持续时间
     */
    private Double durationTime;

    /**
     * 冷却时间
     */
    private Double coolingTime;

    /**
     * 元素能量
     */
    private Double elementalEnergy;

    /**
     * 圣遗物、武器特效等元素爆发效果伤害提升
     */
    private Double up;

    public ElementalBurst(Double up) {
        this.up = up;
    }

    public static ElementalBurst getInstanceByDamageUp(Double up){
        return new ElementalBurst(up);
    }
}
