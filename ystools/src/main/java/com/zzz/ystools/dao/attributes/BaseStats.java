package com.zzz.ystools.dao.attributes;

/**
 * 角色基础属性
 * @Date: 2023/9/1 15:21
 * @Since: 1.0
 * @Auther：zzz 
 */
@Deprecated
public class BaseStats {
    /**
     * 生命值上限hp
     */
    private Integer healthPoints;

    /**
     * 攻击力atk
     */
    private Integer attack;

    /**
     * 防御力def
     */
    private Integer defence;

    /**
     * 元素精通
     */
    private Integer elementalMastery;

    /**
     * 体力上限
     */
    private final Integer maxStamina = 240;
}
