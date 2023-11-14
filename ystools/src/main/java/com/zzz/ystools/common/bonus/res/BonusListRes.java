package com.zzz.ystools.common.bonus.res;

import com.zzz.ystools.common.utils.MapUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author zzz
 * @description 规定所有加成乘区方法的返回类型以此类的形式。
 * @date 2023-10-19 21:45
 */
@Data
// @NoArgsConstructor
@AllArgsConstructor
@Builder
// @ToString
public class BonusListRes {
    private AttrBonusRes attrBonusRes;

    private DmgBonusRes dmgBonusRes;

    // 加成来源
    private String source;

    public static class Builder {
        private AttrBonusRes attrBonusRes;

        private DmgBonusRes dmgBonusRes;
        private String source;

        public Builder attrBonusRes(AttrBonusRes attrBonusRes) {
            this.attrBonusRes = attrBonusRes;
            return this;
        }

        public Builder dmgBonusRes(DmgBonusRes dmgBonusRes) {
            this.dmgBonusRes = dmgBonusRes;
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public BonusListRes build() {
            // 在build()方法中检查内部对象是否为空
            if (attrBonusRes == null){
                attrBonusRes = new AttrBonusRes();
            }
            if (dmgBonusRes == null) {
                dmgBonusRes = new DmgBonusRes();
            }

            if (source == null) {
                source = "";
            }

            return new BonusListRes(attrBonusRes, dmgBonusRes, source);
        }
    }


    /**
     * 合并两个BonusListRes的成员变量AttrBonusRes。
     * 成员要对应合并。并且对应的key的值要合并。
     */
    public static AttrBonusRes mergeAbr(BonusListRes ... bonusListRes) {
        AttrBonusRes res = new AttrBonusRes();
        for (BonusListRes blr : bonusListRes) {
            AttrBonusRes temp = blr.getAttrBonusRes();
            res.merge(temp);
        }
        return res;
    }

    public static BonusListRes merge(BonusListRes map1, BonusListRes map2) {
        AttrBonusRes abr = new AttrBonusRes();
        abr.setBonusList(MapUtils.mergeMaps(map1.getAttrBonusRes().getBonusList(),
                                    map2.getAttrBonusRes().getBonusList()));
        DmgBonusRes dbr = new DmgBonusRes();
        dbr.setBonusList(MapUtils.mergeMaps(map1.getDmgBonusRes().getBonusList(),
                                    map2.getDmgBonusRes().getBonusList()));
        String source = map1.getSource() + " "  + map2.getSource();
        return new BonusListRes(abr, dbr, source.trim());
    }

    public static BonusListRes mergeAll(BonusListRes ... bonusListRes) {
        BonusListRes res = new Builder().build();
        for (BonusListRes blr : bonusListRes) {
            res = BonusListRes.merge(res, blr);
        }
        return res;
    }


    @Override
    public String toString() {
        return "BonusListRes{" +
                "attrBonusRes=" + attrBonusRes +
                ", dmgBonusRes=" + dmgBonusRes +
                ", source='" + source + '\'' +
                '}';
    }
}
