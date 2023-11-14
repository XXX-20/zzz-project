package com.zzz.ystools.dao;

import com.baomidou.mybatisplus.annotation.TableName;

import com.zzz.ystools.dao.attributes.BaseInformation;
import lombok.*;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;

/**
 * @author zzz
 * @description 角色模版
 * @date 2023-08-21 23:40
 */

/**
 CREATE TABLE `character_attr` (
 `id` int NOT NULL COMMENT 'id',
 `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
 `special_dish` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '称号',
 `level` int DEFAULT '90' COMMENT '角色等级',
 `region` varchar(255) DEFAULT NULL COMMENT '国家',
 `weapon_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '武器类型',
 `element_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '元素属性',
 `break_attr` varchar(255) DEFAULT NULL COMMENT '突破属性(固定格式：属性名称：属性值百分比)',
 `health_points` float DEFAULT NULL COMMENT '生命值上限hp',
 `attack` float DEFAULT NULL COMMENT '攻击力atk',
 `defence` float DEFAULT NULL COMMENT '防御力def',
 `elemental_mastery` float DEFAULT '0' COMMENT '元素精通',
 `max_stamina` int DEFAULT '240' COMMENT '体力上限',
 `critical_rate` float DEFAULT '5' COMMENT '暴击率',
 `critical_damage` float DEFAULT '50' COMMENT '暴击伤害',
 `healing_bonus` float DEFAULT '0' COMMENT '治疗加成',
 `incoming_healing_bonus` float DEFAULT '0' COMMENT '受治疗加成',
 `energy_recharge` float DEFAULT '100' COMMENT '元素充能效率',
 `cd_reduction` float DEFAULT '0' COMMENT '冷却缩减',
 `shield_strength` float DEFAULT '0' COMMENT '护盾强效',
 `pyro_dmg_bonus` float DEFAULT '0' COMMENT '火元素伤害加成',
 `pyro_res` float DEFAULT '0' COMMENT '火元素抗性',
 `hydro_dmg_bonus` float DEFAULT '0' COMMENT '水元素伤害加成',
 `hydro_res` float DEFAULT '0' COMMENT '水元素抗性',
 `dendro_dmg_bonus` float DEFAULT '0' COMMENT '草元素伤害加成',
 `dendro_res` float DEFAULT '0' COMMENT '草元素抗性',
 `electro_dmg_bonus` float DEFAULT NULL COMMENT '雷元素伤害加成',
 `electro_res` float DEFAULT '0' COMMENT '雷元素抗性',
 `anemo_dmg_bonus` float DEFAULT '0' COMMENT '风元素伤害加成',
 `anemo_res` float DEFAULT '0' COMMENT '风元素抗性',
 `cryo_dmg_bonus` float DEFAULT '0' COMMENT '冰元素伤害加成',
 `cryo_res` float DEFAULT '0' COMMENT '冰元素抗性',
 `geo_dmg_bonus` float DEFAULT '0' COMMENT '岩元素伤害加成',
 `geo_res` float DEFAULT '0' COMMENT '岩元素抗性',
 `physical_dmg_bonus` float DEFAULT '0' COMMENT '物理伤害加成',
 `physical_res` float DEFAULT '0' COMMENT '物理抗性',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("character_attr")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterAttr extends BaseInformation {

    private Long id;

    /**
     * 角色等级
     */
    private int level;

    /**
     * 突破属性
     * 固定格式：属性名称：属性值百分比
     */
    private String breakAttr;

//   ------------角色面板·基础属性-------------
    /**
     * 生命值上限hp
     */
    private double healthPoints;

    /**
     * 基础攻击力atk
     */
    private double attack;

    /**
     * 防御力def
     */
    private double defence;

    /**
     * 元素精通
     */
    private double elementalMastery;

    /**
     * 体力上限
     */
    private int maxStamina;


    //   ------------角色面板·进阶属性-------------
    /**
     * 暴击率 CRIT
     */
    private double criticalRate;

    /**
     * 暴击伤害 CRIT DMG
     */
    private double criticalDamage;

    /**
     * 治疗加成
     */
    private double healingBonus;

    /**
     * 受治疗加成
     */
    private double incomingHealingBonus;

    /**
     * 元素充能效率
     */
    private double energyRecharge;

    /**
     * 冷却缩减
     */
    private double cdReduction;

    /**
     * 护盾强效
     */
    private double shieldStrength;

    //   ------------角色面板·元素属性-------------
    /**
     * 火元素伤害加成
     */
    private double pyroDmgBonus;

    /**
     * 火元素抗性
     */
    private double pyroRes;

    /**
     * 水元素伤害加成
     */
    private double hydroDmgBonus;

    /**
     * 水元素抗性
     */
    private double hydroRes;

    /**
     * 草元素伤害加成
     */
    private double dendroDmgBonus;

    /**
     * 草元素抗性
     */
    private double dendroRes;

    /**
     * 雷元素伤害加成
     */
    private double electroDmgBonus;

    /**
     * 雷元素抗性
     */
    private double electroRes;

    /**
     * 风元素伤害加成
     */
    private double anemoDmgBonus;

    /**
     * 风元素抗性
     */
    private double anemoRes;

    /**
     * 冰元素伤害加成
     */
    private double cryoDmgBonus;

    /**
     * 冰元素抗性
     */
    private double cryoRes;

    /**
     * 岩元素伤害加成
     */
    private double geoDmgBonus;

    /**
     * 岩元素抗性
     */
    private double geoRes;


    /**
     * 物理伤害加成
     */
    private double physicalDmgBonus;

    /**
     * 物理抗性
     */
    private double physicalRes;


    public CharacterAttr(CharacterAttr original) {
        try {
            BeanUtils.copyProperties(this, original);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取角色突破属性
     */
    @Deprecated
    public HashMap<String, Double> handleBreakAttr() {
        String[] split = this.breakAttr.split(":");
        return new HashMap<String, Double>(){{
            put(split[0], Double.valueOf(split[1].substring(0, split[1].length() - 1)));
        }};
    }


    public String getDataPanel() {
        return "CharacterAttr{" +
                "level=" + level +
                ", healthPoints=" + healthPoints +
                ", attack=" + attack +
                ", defence=" + defence +
                ", elementalMastery=" + elementalMastery +
                ", criticalRate=" + criticalRate +
                ", criticalDamage=" + criticalDamage +
                ", energyRecharge=" + energyRecharge +
                "} ";
    }
}
