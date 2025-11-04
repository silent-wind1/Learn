package com.yefeng.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class JsonUtils {
    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();
        return gson.toJson(obj);
    }

    /**
     * JSON转对象（普通对象）
     *
     * @param json     json字符串
     * @param classOfT 对象类型
     * @return 对象
     */
    public static <T> T fromJson(String json, Class<T> classOfT) {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return gson.fromJson(json, classOfT);
    }
}
