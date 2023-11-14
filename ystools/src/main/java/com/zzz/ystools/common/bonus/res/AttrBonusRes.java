package com.zzz.ystools.common.bonus.res;


import com.zzz.ystools.common.utils.MapUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 属性乘区加成统一返回对象
 *
 * @Date: 2023/10/17 17:19
 * @Since: 1.0
 * @Auther：zzz
 */
@Data
@NoArgsConstructor
public class AttrBonusRes {
    // eg:  基础攻击力（汉字）， 542.0（浮点数）
    private Map<String, Double> bonusList = new HashMap<>();

    public AttrBonusRes(String type, Double data) {
        bonusList.put(type, data);
    }

    public static AttrBonusRes getInstance(String type, Double data) {
        return new AttrBonusRes(type, data);
    }

    public AttrBonusRes add(AttrBonusRes addBonus) {
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

    public AttrBonusRes add(String type, Double data) {
        if (this.bonusList.containsKey(type)) {
            this.bonusList.put(type, this.bonusList.get(type) + data);
            return this;
        }
        this.bonusList.put(type, data);
        return this;
    }

    @Override
    public String toString() {
        return "AttrBonusRes{" +
                "bonusList=" + bonusList +
                '}';
    }

    public AttrBonusRes merge(AttrBonusRes attrBonusRes) {
        Map<String, Double> list = attrBonusRes.getBonusList();
        this.setBonusList(MapUtils.mergeMaps(this.getBonusList(), list));
        return this;
    }
}
