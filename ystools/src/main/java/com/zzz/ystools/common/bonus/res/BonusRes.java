package com.zzz.ystools.common.bonus.res;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class BonusRes {

    private Map<String, Double> bonusList = new HashMap<>();

    public BonusRes add(BonusRes addBonus) {
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

    public BonusRes add(String type, Double data) {
        if (this.bonusList.containsKey(type)) {
            this.bonusList.put(type, this.bonusList.get(type) + data);
            return this;
        }
        this.bonusList.put(type, data);
        return this;
    }
}
