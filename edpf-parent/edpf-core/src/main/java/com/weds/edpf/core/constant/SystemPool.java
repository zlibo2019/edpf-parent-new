package com.weds.edpf.core.constant;

import com.weds.core.utils.MapCacheUtils;

import java.util.HashMap;
import java.util.Map;

public class SystemPool {
    public static String getToken() {
        Object obj = MapCacheUtils.single().get("access_token");
        return obj == null ? "" : obj.toString();
    }

    public static Object getToken(String key) {
        return MapCacheUtils.single().get("token" + key);
    }

    public static void addToken(String token) {
        MapCacheUtils.single().set("access_token", token);
    }

    public static void addToken(String key, Object value) {
        MapCacheUtils.single().set("token" + key, value);
    }

    public static String getTicket() {
        Object obj = MapCacheUtils.single().get("ticket");
        return obj == null ? "" : obj.toString();
    }

    public static Object getTicket(String key) {
        return MapCacheUtils.single().get("ticket" + key);
    }

    public static void addTicket(String ticket) {
        MapCacheUtils.single().set("ticket", ticket);
    }

    public static void addTicket(String key, Object value) {
        MapCacheUtils.single().set("ticket" + key, value);
    }
}
