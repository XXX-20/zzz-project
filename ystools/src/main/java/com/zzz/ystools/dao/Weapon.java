package com.zzz.ystools.dao;


import com.baomidou.mybatisplus.annotation.TableName;
import com.zzz.ystools.common.bonus.res.AttrBonusRes;
import lombok.Data;

/**
 * 武器类。
 * 默认90级。
 * @Date: 2023/10/12 17:16
 * @Since: 1.0
 * @Auther：zzz
 */
@Data
@TableName("weapon")
public class Weapon {
    /**
     * id
     */
    private Long id;

    /**
     * 武器类型
     */
    private String weaponType;
    /**
     * 名称
     */
    private String name;
    /**
     * 星级
     * PS:不能叫rank，否则会报sql错误。
     */
    private String rankNum;
    /**
     * 精炼等级
     */
    private int refinement;
    /**
     * 主属性类型
     */
    private String mainAttr;
    /**
     * 主属性值
     */
    private Double mainAttrValue;
    /**
     * 副属性类型
     */
    private String secondaryAttr;
    /**
     * 副属性值
     */
    private Double secondaryAttrValue;
    /**
     * 特殊效果
     */
    private String specialEffects;

    public AttrBonusRes getBonus() {
        return (AttrBonusRes) AttrBonusRes.getInstance(mainAttr, mainAttrValue)
                .add(secondaryAttr, secondaryAttrValue);
    }

}
