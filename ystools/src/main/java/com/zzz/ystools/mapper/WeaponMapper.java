package com.zzz.ystools.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zzz.ystools.dao.Weapon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeaponMapper extends BaseMapper<Weapon> {

    default Weapon getWeaponAttrByName(String name) {
        return selectOne(new LambdaQueryWrapper<Weapon>().eq(Weapon::getName, name));
    }
}
