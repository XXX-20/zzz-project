package com.zzz.ystools.weapon;



import com.zzz.ystools.common.bonus.res.AttrBonusRes;
import com.zzz.ystools.common.bonus.res.BonusListRes;
import com.zzz.ystools.common.bonus.res.DmgBonusRes;
import com.zzz.ystools.dao.Weapon;
import com.zzz.ystools.enums.BonusEnum;
import com.zzz.ystools.enums.WeaponTypeEnum;
import com.zzz.ystools.service.WeaponServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 弓箭类型
 */
@Component
public class Bow extends Weapon {

    @Autowired
    WeaponServiceImpl weaponService;

    private static Bow bow;

    @PostConstruct
    public void init() {
        bow = this;
        bow.weaponService = this.weaponService;
        bow.setWeaponType(WeaponTypeEnum.Bow.getDescription());
    }

    /**
     * 根据武器中文名得到对应的武器类型对象。
     *
     * @param name 武器中文名
     * @return 武器
     */
    private Weapon getInstance(String name) {
        return bow.weaponService.getWeaponAttrByName(name);
    }

    /**
     * 提供给外部调用，执行对应weaponName的方法，并返回结果
     *
     * @param weaponName 武器名（中文拼音）
     * @param refinement 精炼等级
     * @return 加成统一返回类
     */
    public static BonusListRes invoke(String weaponName, int refinement) {
        Class<?> bow = Bow.class;
        Method method = null;
        try {
            method = bow.getDeclaredMethod(weaponName, int.class);
            return (BonusListRes) method.invoke(new Bow(), refinement);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("该武器暂未录入");
        }

    }

    /**
     * 若水特效:
     * 生命值提升（16%/20%/24%/28%/32%)。
     * 周围存在敌人时，装备该武器的角色造成的伤害都会提升（20%/25%/30%/35%/40%)，不论该角色处于场上或是处于队伍后台。
     * 方法默认吃满加成。
     *
     * @Parms: refinement 精炼等级
     * @Return: 鉴于武器特效大都设计属性乘区和伤害乘区。所以返回一个List<BonusRes>。并且默认第一个是AttrBonusRes
     *              第二个是DmgBonusRes
     * @Date: 2023/10/13 16:51
     * @Since: 1.0
     * @Auther：zzz
     */
    public BonusListRes 若水(int refinement) {
        Weapon instance = this.getInstance("若水");
        // System.out.println("instance = " + instance);
        double hp = 16 + (refinement - 1) * 4;
        double b = 20 + (refinement - 1) * 5;
        AttrBonusRes attrBonusRes = instance.getBonus().add(BonusEnum.HP_PERCENT.getDescription(), hp);
        DmgBonusRes dmgBonusRes = DmgBonusRes.getInstance(BonusEnum.B.getDescription(), b);
        return new BonusListRes.Builder()
                .attrBonusRes(attrBonusRes)
                .dmgBonusRes(dmgBonusRes)
                .source(bow.getWeaponType() + "-若水").build();
    }
}
