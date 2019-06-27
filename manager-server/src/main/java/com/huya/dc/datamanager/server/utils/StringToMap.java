package com.huya.dc.datamanager.server.utils;

import java.util.HashMap;
import java.util.Map;

public abstract class StringToMap {
    public static Map<String,String> stringToMap(String content,String entrySep,String kvSep){
        Map<String,String> map = new HashMap<>();
        String[] entry = content.split(entrySep);
        for (int i=0;i<entry.length;i++){
            String[] tmp = entry[i].split(kvSep);
            map.put(tmp[0],tmp[1]);
        }
        return map;
    }
}
