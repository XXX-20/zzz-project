package com.zzz.ystools.common.utils;


import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    /**
     * 合并两个map，把两个map相同的键的值相加。
     */
    public static Map<String, Double> mergeMaps(Map<String, Double> map1, Map<String, Double> map2) {
        Map<String, Double> mergedMap = new HashMap<>(map1);

        // 遍历第二个Map，并将相同键的值相加
        for (Map.Entry<String, Double> entry : map2.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();

            // 如果合并Map中已经包含相同键，则将值相加
            if (mergedMap.containsKey(key)) {
                mergedMap.put(key, mergedMap.get(key) + value);
            } else {
                mergedMap.put(key, value);
            }
        }
        return mergedMap;
    }
}
