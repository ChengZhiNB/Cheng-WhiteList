package cn.ChengZhiYa.WhitelistBungeeCore;

import java.util.HashMap;

public class Int_HashMap {
    static HashMap<String, Integer> Temp = new HashMap<>();

    public static void Set(String HashMapName, Integer Value) {
        Temp.put(HashMapName, Value);
    }

    public static Integer Get(String HashMapName) {
        return Temp.get(HashMapName);
    }
}
