package com.zzz.ystools.service;


import com.zzz.ystools.YstoolsApplication;
import com.zzz.ystools.dao.Weapon;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = YstoolsApplication.class)
class WeaponServiceImplTest {


    @Resource
    WeaponService weaponService;

    @Test
    public void getWeaponAttrByName() {
        Weapon weaponAttrByName = weaponService.getWeaponAttrByName("若水");
        System.out.println("weaponAttrByName = " + weaponAttrByName);
    }
}