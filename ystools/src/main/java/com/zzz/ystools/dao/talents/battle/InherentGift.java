package com.zzz.ystools.dao.talents.battle;


import com.zzz.ystools.common.DmgComputeArg;
import com.zzz.ystools.common.bonus.res.BonusListRes;

/**
 * 固有天赋类
 * @Date: 2023/10/9 11:19
 * @Since: 1.0
 * @Auther：zzz 
 */
public interface InherentGift {
    BonusListRes one(DmgComputeArg dmgComputeArg);

    BonusListRes two(DmgComputeArg dmgComputeArg);

}
