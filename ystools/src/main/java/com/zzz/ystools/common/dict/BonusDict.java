package com.zzz.ystools.common.dict;


import com.zzz.ystools.enums.BonusEnum;

/**
 * 加成区间-字典转换工具类
 * @Date: 2023/10/13 16:30
 * @Since: 1.0
 * @Auther：zzz
 */
public class BonusDict {
    public static String cToE(String bonus) {
        if (bonus.equals(BonusEnum.ATK_BASE.getDescription())) {
            return BonusEnum.ATK_BASE.name();
        }
        return "null";
    }
}
