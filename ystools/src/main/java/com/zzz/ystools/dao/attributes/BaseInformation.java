package com.zzz.ystools.dao.attributes;

import lombok.Data;

/**
 * @author zzz
 * @description 角色基础信息
 * @date 2023-08-23 21:03
 */
@Data
public class BaseInformation {
    /**
     * 称号
     */
    private String specialDish;

    /**
     * 名称
     */
    private String name;

    /**
     * 国家
     */
    private String region;

    /**
     * 武器类型
     */
    private String weaponType;

    /**
     * 元素属性
     */
    private String elementType;

    /**
     * 角色星级
     */
    private String starLevel;
}
