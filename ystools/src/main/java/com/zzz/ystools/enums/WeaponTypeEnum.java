package com.zzz.ystools.enums;

/**
 * @author zzz
 * @description 武器类型枚举类
 * @date 2023-08-23 21:09
 */
public enum WeaponTypeEnum {

    Bow("弓");


    private final String description;

    WeaponTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
