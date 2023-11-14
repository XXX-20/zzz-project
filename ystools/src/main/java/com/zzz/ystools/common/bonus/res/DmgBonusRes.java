package com.zzz.ystools.common.bonus.res;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 伤害乘区加成统一返回对象
 * @Date: 2023/10/10 16:35
 * @Since: 1.0
 * @Auther：zzz 
 */
@Data
@NoArgsConstructor
public class DmgBonusRes{

    // eg:  增伤区（汉字）， 40.0（浮点数）
    private Map<String, Double> bonusList = new HashMap<>();

    public DmgBonusRes(String type, Double data) {
        bonusList.put(type, data);
    }

    public static DmgBonusRes getInstance(String type, Double data){
        return new DmgBonusRes(type, data);
    }

    public DmgBonusRes add(DmgBonusRes addBonus) {
        Map<String, Double> add = addBonus.getBonusList();
        for (String s : add.keySet()) {
            if (this.bonusList.containsKey(s)) {
                this.bonusList.put(s, this.bonusList.get(s) + add.get(s));
                continue;
            }
            this.bonusList.put(s, add.get(s));
        }
        return this;
    }

    public DmgBonusRes add(String type, Double data) {
        if (this.bonusList.containsKey(type)) {
            this.bonusList.put(type, this.bonusList.get(type) + data);
            return this;
        }
        this.bonusList.put(type, data);
        return this;
    }

    @Override
    public String toString() {
        return "BonusRes{" +
                "bonusList=" + bonusList +
                '}';
    }
}
