package com.zzz.ystools.common;


import com.zzz.ystools.artifact.Artifact;
import com.zzz.ystools.common.bonus.res.AttrBonusRes;
import com.zzz.ystools.common.bonus.res.BonusListRes;
import com.zzz.ystools.common.bonus.res.DmgBonusRes;
import com.zzz.ystools.dao.CharacterAttr;
import com.zzz.ystools.dao.talents.battle.InherentGift;
import com.zzz.ystools.monster.Monster;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 伤害计算参数类。类成员就是影响伤害的因素。
     * 伤害受以下因素影响（按照计算先后排序）：
     * 1.武器
     * 2.角色天赋
 *       天赋的加成有一定限制条件，限制条件也作为该类的成员变量。
     * 3.圣遗物词条加成
     * 4.圣遗物套装效果
     * 5.原魔属性
 * @Date: 2023/10/19 14:32
 * @Since: 1.0
 * @Auther：zzz 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DmgComputeArg {
    private String bowName;

    private InherentGift gift;

    // 乘区(汉字)，数值
    private Map<String, Double> artifactEntries;

    // name（汉字）, suitNum
    private Map<String, Integer> artifactSuit;


    private Monster monster;

    // 队伍人数
    private int teamNum;
    // 站场时间
    private double residentTime;
    // 当前角色名称
    private String currCharName;

    /**
     * 将dmgComputeArg的圣遗物词条加成ArtifactEntries从Map类型转换成List<BonusRes>
     */
    public BonusListRes getArtifactEntries() {
        AttrBonusRes attrBonusRes = new AttrBonusRes();
        DmgBonusRes dmgBonusRes = new DmgBonusRes();
        for (String bonusName : artifactEntries.keySet()) {
            if (bonusName.equals("伤害加成")) {
                dmgBonusRes.add(bonusName, artifactEntries.get(bonusName));
                continue;
            }
            attrBonusRes.add(bonusName, artifactEntries.get(bonusName));
        }
        return new BonusListRes(attrBonusRes, dmgBonusRes, "圣遗物词条效果");
    }

    /**
     * 将dmgComputeArg的ArtifactSuit从Map类型转换成BonusListRes
     */
    public BonusListRes getArtifactSuit(CharacterAttr characterAttr) {
        AttrBonusRes attrBonusRes = new AttrBonusRes();
        DmgBonusRes dmgBonusRes = new DmgBonusRes();
        BonusListRes res = new BonusListRes.Builder().build();
        for (String artiName : artifactSuit.keySet()) {
            // 获取（佩戴的）每一种圣遗物套装效果
            BonusListRes invoke = Artifact.invoke(artiName, artifactSuit.get(artiName), characterAttr);
            if (invoke != null) {
                res = BonusListRes.merge(res, invoke);
            }
        }
        return res;
    }
}
