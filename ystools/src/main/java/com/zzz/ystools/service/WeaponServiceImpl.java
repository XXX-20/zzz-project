package com.zzz.ystools.service;


import com.zzz.ystools.dao.Weapon;
import com.zzz.ystools.mapper.WeaponMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WeaponServiceImpl implements WeaponService{

    @Resource
    WeaponMapper weaponMapper;

    @Override
    public Weapon getWeaponAttrByName(String name) {
        return weaponMapper.getWeaponAttrByName(name);
    }

}
