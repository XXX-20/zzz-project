package com.zzz.ystools.common.dict;


import java.util.HashMap;

public class ArtifactDict {

    static HashMap<String, String> dict = new HashMap<String, String>(){{
        put("绝缘", "emblemOfSeveredFate");
        put("绝缘之旗印", "emblemOfSeveredFate");
    }};

    public static String cToE(String artifactName) {
        if (dict.containsKey(artifactName)) {
            return dict.get(artifactName);
        }
        return "圣遗物名称错误或未录入";
    }
}
