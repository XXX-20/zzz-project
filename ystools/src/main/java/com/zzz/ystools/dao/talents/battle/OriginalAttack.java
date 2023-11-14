package com.zzz.ystools.dao.talents.battle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzz
 * @description 普通攻击
 * @date 2023-08-23 21:28
 * 普攻段数和武器类型有关，但并不固定，短的三段、多的七段。这里创建七个成员变量表示。
 * 默认倍率为攻击率。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OriginalAttack {

    /**
     * 普攻各段伤害
     */
    Double firstStageInjury;

    private Double secondStageInjury;

    private Double thirdStageInjury;

    private Double forthStageInjury;

    private Double fifthStageInjury;

    private Double sixthStageInjury;

    private Double seventhStageInjury;

    /**
     * 重击伤害
     */
    private Double heavyInjury;

    /**
     * 重击体力消耗
     */
    private Double heavyPhysicalExertion;

    /**
     * 低空坠地冲击伤害
     */
    private Double lowFallingInjury;

    /**
     * 高空坠地冲击伤害
     */
    private Double highFallingInjury;

    /**
     * 下坠期间伤害
     */
    private Double duringFallingInjury;


    /**
     * 瞄准伤害
     */
    private Double aimingDamage;


}
